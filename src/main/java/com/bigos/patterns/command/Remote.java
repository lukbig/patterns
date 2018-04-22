package com.bigos.patterns.command;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Handler class. Different approaches can be applied to this pattern.
 * The first is this one. In the second one, command can only be treated as container
 * and handler performs an actions.
 */

@NoArgsConstructor
@Slf4j
public class Remote {

    private Deque<Command> undoStack = new LinkedList<>();

    public void changeChannel(Command command, Tv tv) {
        log.info("{} performs {} on {}", this, command, tv);
        command.execute(tv);
        undoStack.offerLast(command);
    }

    public void undoLastChange() {
        if (!undoStack.isEmpty()) {
            Command previous = undoStack.pollLast();
            log.info("{} undoes {}", this, previous);
            previous.undo();
        }
    }

    @Override
    public String toString() {
        return "Remote";
    }
}


