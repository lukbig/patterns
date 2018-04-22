package com.bigos.patterns.command;

public interface Command {
    void execute(Tv tv);

    void undo();
}
