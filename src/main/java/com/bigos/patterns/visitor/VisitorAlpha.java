package com.bigos.patterns.visitor;

public class VisitorAlpha implements Visitor {
    @Override
    public void applyTo(Subject subject) {
        subject.setState(subject.getState() + " visited by alpha");
    }

    @Override
    public boolean appliesTo(Subject subject) {
        return true;
    }
}
