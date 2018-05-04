package com.bigos.patterns.visitor;

import java.util.List;

import static java.util.Arrays.asList;

public class App {

    private final List<Visitor> visitors = asList(new VisitorAlpha(), new VisitorBravo());

    void visitSubjects(List<Subject> subjects) {
        subjects.forEach(this::applyVisitors);
    }

    private void applyVisitors(Subject subject) {
        visitors.forEach(visitor -> {
            if (visitor.appliesTo(subject)) {
                visitor.applyTo(subject);
            }
        });
    }
}
