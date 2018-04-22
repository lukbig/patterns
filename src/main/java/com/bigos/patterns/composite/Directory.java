package com.bigos.patterns.composite;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class Directory extends Component {

    private List<Component> components;

    private String name;

    public Directory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    @Override
    public void print() {
        System.out.println(name);
        components.forEach(Component::print);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean addElement(Component component) {
        return !componentsContains(component.getName()) && components.add(component);
    }

    @Override
    public boolean removeElement(Component component) {
        return components.remove(component);
    }

    @Override
    public int getSize() {
        return components.size();
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    private boolean componentsContains(String name) {
        return components.stream().anyMatch(e -> e.getName().equals(name));
    }
}
