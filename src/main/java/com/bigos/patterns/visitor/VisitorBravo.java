package com.bigos.patterns.visitor;

public class VisitorBravo implements Visitor {
    @Override
    public void applyTo(Subject subject) {
        subject.setState(subject.getState() + " visited by bravo");
    }

    @Override
    public boolean appliesTo(Subject subject) {
        return true;
    }
}
