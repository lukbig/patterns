package com.bigos.patterns.mediator;

import lombok.Data;

@Data
public class Participant {

    private final Mediator mediator;

    private String message;

    public void send(String message) {
        mediator.sendMessage(this, message);
    }
}
