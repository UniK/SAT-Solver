package com.kukushkin.logic.parser;

import java.util.Map;
import java.util.Set;

public class Implication extends BinaryOperation {

    private Formula left_arg, right_arg;

    public Implication(Formula f, Formula g) {
        left_arg = f;
        right_arg = g;
    }

    public Formula get_left_arg() {
        return left_arg;
    }

    public Formula get_right_arg() {
        return right_arg;
    }

    public boolean eval(Map<String, Boolean> valuation) {
//        return right_arg.eval(valuation) ? left_arg.eval(valuation) : true;
        return !left_arg.eval(valuation) || right_arg.eval(valuation) ;
    }
}
