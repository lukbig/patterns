package com.bigos.patterns.composite;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class File extends Component {

    private final String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println(name);
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean addElement(Component component) {
        throw new UnsupportedOperationException("Cannot add element");
    }

    @Override
    public boolean removeElement(Component component) {
        throw new UnsupportedOperationException("Cannot remove element");
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Cannot get size");
    }
}

