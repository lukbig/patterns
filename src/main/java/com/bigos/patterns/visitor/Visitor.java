package com.bigos.patterns.visitor;

public interface Visitor {
    void applyTo(Subject subject);

    boolean appliesTo(Subject subject);
}
