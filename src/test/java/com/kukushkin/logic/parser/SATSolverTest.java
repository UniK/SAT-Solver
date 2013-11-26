package com.kukushkin.logic.parser;

import com.kukushkin.logic.Solver;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.StringReader;
import java.util.*;

/**
 * Unit tests for SAT-Solver.
 */
public class SATSolverTest {

    final Solver solver = new Solver();

    @Test public void simpleTest() {
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        boolean result =  false;
        try {
            final String s = "A -> -A";
            System.out.println("Testing: " + s);
            Scanner scanner = new Scanner(new StringReader(s));
            parser p = new parser(scanner);
            Formula f = (Formula) p.parse().value;
            result = solver.validate(f);

        } catch (Exception e) {
            System.out.println("+" + e);
        }
        Assert.assertTrue(result);
        System.out.println("> The formula is "  + (result ? "solvable." : "not solvable."));
        System.out.println("-------------------------------------------------------");
    }

    @Test public void simpleTest2() {
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        boolean result =  false;
        try {
            final String s = "A | B & C";
            System.out.println("Testing: " + s);
            Scanner scanner = new Scanner(new StringReader(s));
            parser p = new parser(scanner);
            Formula f = (Formula) p.parse().value;
            result = solver.validate(f);

        } catch (Exception e) {
            System.out.println("+" + e);
        }
        Assert.assertTrue(result);
        System.out.println("> The formula is "  + (result ? "solvable." : "not solvable."));
        System.out.println("-------------------------------------------------------");
    }


    @Test public void helloWorldTest() {
        System.out.println("-------------------------------------------------------");
        boolean result =  false;
        try {
            final String s = "-A & (B | -(C <-> HalloWelt) | (-B -> A -> -C))";
            System.out.println("Testing: " + s);

            Scanner scanner = new Scanner(new StringReader(s));
            parser p = new parser(scanner);
            Formula f = (Formula) p.parse().value;

            result = solver.validate(f);

        } catch (Exception e) {
        }
        Assert.assertTrue(result);
        System.out.println("> The formula is "  + (result ? "solvable." : "not solvable."));
        System.out.println("-------------------------------------------------------");
    }


    @Test public void solvableBiimplicantTest() {
        System.out.println("-------------------------------------------------------");
        boolean result =  false;
        try {
            final String s = "((((X0<->X1)<->X2)<->X3)<->X4)&(X4<->X2)&(X3<->X1)&(X2<->X0)&-(X1<->X0)";
            System.out.println("Testing: " + s);

            Scanner scanner = new Scanner(new StringReader(s));
            parser p = new parser(scanner);
            Formula f = (Formula) p.parse().value;

            result = solver.validate(f);

        } catch (Exception e) {
        }
        Assert.assertTrue(result);
        System.out.println("> The formula is "  + (result ? "solvable." : "not solvable."));
        System.out.println("-------------------------------------------------------");
    }


    @Test public void benchmark422Test() {
        System.out.println("-------------------------------------------------------");
        boolean result =  false;
        try {
            final String s = "(P0s0|P0s1)&(P1s0|P1s1)&-(P0s0&P1s0)&-(P0s1&P1s1)";
            System.out.println("Testing: " + s);

            Scanner scanner = new Scanner(new StringReader(s));
            parser p = new parser(scanner);
            Formula f = (Formula) p.parse().value;

            result = solver.validate(f);

        } catch (Exception e) {
        }
        Assert.assertTrue(result);
        System.out.println("> The formula is "  + (result ? "solvable." : "not solvable."));
        System.out.println("-------------------------------------------------------");
    }


    @Test public void failTest() {
        System.out.println("-------------------------------------------------------");
        boolean result =  false;
        try {
            final String s = "-A & A";
            System.out.println("Testing: " + s);

            Scanner scanner = new Scanner(new StringReader(s));
            parser p = new parser(scanner);
            Formula f = (Formula) p.parse().value;

            result = solver.validate(f);

        } catch (Exception e) {
        }
        Assert.assertFalse(result);

        System.out.println("> The formula is "  + (result ? "solvable." : "not solvable."));
        System.out.println("-------------------------------------------------------");
    }


    @Test public void failTest2() {
        System.out.println("-------------------------------------------------------");
        boolean result =  false;
        try {
            final String s = "(((((X0<->X1)<->X2)<->X3)<->X4)<->X5)&(X5<->X3)&(X4<->X2)&(X3<->X1)&(X2<->X0)&-(X1<->X0)";
            System.out.println("Testing: " + s);

            Scanner scanner = new Scanner(new StringReader(s));
            parser p = new parser(scanner);
            Formula f = (Formula) p.parse().value;

            result = solver.validate(f);

        } catch (Exception e) {
        }
        Assert.assertFalse(result);
        System.out.println("> The formula is "  + (result ? "solvable." : "not solvable."));
        System.out.println("-------------------------------------------------------");
    }


    /*
    private boolean validate(Formula f) {
        //
        // collects all available variables
        SortedSet<String> vars = f.collectFVs();
        System.out.println("Found variables: " + vars);

        Map<String, Boolean> valuation = new HashMap<String, Boolean>();
        boolean result = false;

        int size = vars.size(); // 3
        int nValuations = (1 << size); // 2^3=8

        for (int valuationCode = 0; valuationCode < nValuations && !result; valuationCode++) {
            valuation.clear();
            int variableNr = 0;
            for (String a : vars) {
                valuation.put(a, ((valuationCode >> variableNr) & 1) > 0);
                System.out.print(a + ":" + ((valuationCode >> variableNr) & 1) + " ");
                variableNr++;
            }
            System.out.println("Solvable: " + (result = f.eval(valuation)));
        }
        return result;
    }
    */

}
