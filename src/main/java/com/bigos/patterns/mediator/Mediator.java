package com.bigos.patterns.mediator;

public interface Mediator {
    void sendMessage(Participant participant, String message);

    void addParticipant(Participant participant);
}
