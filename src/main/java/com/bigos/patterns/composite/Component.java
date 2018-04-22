package com.bigos.patterns.composite;

public abstract class Component {

    public abstract String getName();

    public abstract boolean addElement(Component component);

    public abstract boolean removeElement(Component component);

    public abstract int getSize();

    public abstract void print();

    public abstract boolean isLeaf();
}
