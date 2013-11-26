package com.kukushkin.logic.parser;

import java.util.Map;
import java.util.SortedSet;

public abstract class Formula {

    public boolean eval(Map<String, Boolean> valuation) {
        throw new UnsupportedOperationException();
    }

    public SortedSet<String> collectFVs() {
        throw new UnsupportedOperationException();
    }
}