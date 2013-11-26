package com.kukushkin.logic.parser;

import java.util.SortedSet;

public abstract class BinaryOperation extends Formula {

    public Formula get_left_arg() {
        throw new UnsupportedOperationException();
    }

    public Formula get_right_arg() {
        throw new UnsupportedOperationException();
    }

    public SortedSet<String> collectFVs() {
        SortedSet<String> vars = get_left_arg().collectFVs();
        vars.addAll(get_right_arg().collectFVs());
        return vars;
    }
}
