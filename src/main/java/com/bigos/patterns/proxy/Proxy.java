package com.bigos.patterns.proxy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Proxy implements Subject {

    private final String state;

    private Subject subject;

    @Override
    public String display() {
        if (subject == null) {
            subject = new RealSubject(state);
        }
        return subject.display();
    }
}
