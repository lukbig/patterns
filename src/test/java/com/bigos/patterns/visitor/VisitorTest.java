package com.bigos.patterns.visitor;

import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Represent an operation to be performed on the elements of an object
 * structure. Visitor lets you define a new operation without changing
 * the classed of the elements on which it operates.
 * Two usage:
 * 1. Presented here - visitor interface with appliesTo and applyTo
 * 2. Subject implementing interface with method accept(Visitor) - Visitor with method visit(subject)
 */

class VisitorTest {

    private static final String STATE = "state";

    @Test
    void shouldVisitSubjectWithVisitors(){
        Subject subject = new Subject(STATE);
        App app = new App();

        app.visitSubjects(singletonList(subject));

        assertThat(subject.getState()).isEqualTo("state visited by alpha visited by bravo");
    }
}