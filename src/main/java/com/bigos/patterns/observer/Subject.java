package com.bigos.patterns.observer;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyAllObservers();

    void setState(String state);

    String getState();
}
