package com.bigos.patterns.observer;

import lombok.Getter;

public class ConcreteObserver implements Observer {

    @Getter
    private String state;

    @Override
    public void update(Subject subject) {
        this.state = subject.getState();
    }
}
