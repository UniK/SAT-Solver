package com.kukushkin.logic;

import com.kukushkin.logic.parser.Formula;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

/**
 * Created by Valentyn Kukushkin.
 */
public class Solver {

    //
    public boolean validate(Formula f) {
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
}
