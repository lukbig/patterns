package com.bigos.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {

    private List<Participant> participants = new ArrayList<>();

    @Override
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    @Override
    public void sendMessage(Participant participant, String message) {
        for(Participant p: participants) {
            if (p != participant) {
                p.setMessage(message);
            }
        }
    }
}
