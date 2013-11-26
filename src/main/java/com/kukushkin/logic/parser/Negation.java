package com.kukushkin.logic.parser;

import java.util.Map;
import java.util.SortedSet;

public class Negation extends Formula {

    private Formula arg;

    public Negation(Formula f) {
        arg = f;
    }

    public Formula get_arg() {
        return arg;
    }

    public boolean eval(Map<String, Boolean> valuation) {
        return !arg.eval(valuation);
    }

    public SortedSet<String> collectFVs() {
        return arg.collectFVs();
    }
}
