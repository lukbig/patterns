package com.bigos.patterns.mediator;

import com.bigos.patterns.extensions.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Define an object that encapsulates how a set of objects interact.
 * Mediator promotes loose coupling by keeping objects from referring
 * to each other explicitly.
 * The mediator object encapsulates all interconnections, acts as the hub
 * of communication, is responsible for controlling and coordinating the
 * interactions of its clients.
 *
 *  What the mediator essentially says to such set of objects is
 *  “talk with me instead of talking among yourselves”.
 *  Therefore, if an existing object is updated with new interaction rules
 *  or a new object is added to the system, it is only the mediator object
 *  that you need to update.
 *  Mediator:
 *  Object 1           Object 2
 *          \        /
 *           Mediator
 *          /        \
 *  Object 3          Object 4
 */

@ExtendWith(MockitoExtension.class)
class MediatorTest {

    private final String MESSAGE = "private message";

    @Mock
    private Participant receiverAlpha;
    @Mock
    private Participant receiverBravo;

    private Mediator mediator;

    private Participant sender;

    @BeforeEach
    void setUp() {
        mediator = new ConcreteMediator();
        sender = new Participant(mediator);
        mediator.addParticipant(sender);
    }

    @Test
    void shouldCommunicateWithTwoParticipants() {
        mediator.addParticipant(receiverAlpha);
        mediator.addParticipant(receiverBravo);

        sender.send(MESSAGE);

        assertThat(sender.getMessage()).isNull();
        verify(receiverAlpha).setMessage(MESSAGE);
        verify(receiverBravo).setMessage(MESSAGE);
    }

    @Test
    void shouldCommunicateWithOneParticipant() {
        mediator.addParticipant(receiverAlpha);

        sender.send(MESSAGE);

        assertThat(sender.getMessage()).isNull();
        verify(receiverAlpha).setMessage(MESSAGE);
        verifyZeroInteractions(receiverBravo);
    }
}