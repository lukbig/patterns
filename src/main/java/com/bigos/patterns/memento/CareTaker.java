package com.bigos.patterns.memento;

import java.util.LinkedList;

public class CareTaker {

    private LinkedList<Memento> mementos = new LinkedList<>();

    public void add(Memento memento) {
        mementos.offer(memento);
    }

    public Memento get() {
        return mementos.poll();
    }
}
