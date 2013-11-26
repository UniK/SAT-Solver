package com.kukushkin.logic.parser;

import java.util.*;

public class Variable extends Formula {

    private String name;

    public Variable(String x) {
        name = x;
    }

    public boolean eval(Map<String, Boolean> valuation) {
        return valuation.get(name);
    }

    public SortedSet<String> collectFVs() {
        SortedSet<String> var = new TreeSet<String>();
        var.add(name);
        return var;
    }

}