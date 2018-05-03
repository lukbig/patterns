package com.bigos.patterns.observer;


import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    private String state;

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    @Override
    public String getState() {
        return state;
    }
}
