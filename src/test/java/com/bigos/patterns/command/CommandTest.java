package com.bigos.patterns.command;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    private static final int CURRENT_CHANNEL = 22;

    @Test
    void shouldExecuteCommand() {
        Command command = new ChannelUpCommand();
        Tv tv = new Tv(CURRENT_CHANNEL);
        Remote remote = new Remote();

        remote.changeChannel(command, tv);

        assertThat(tv.getChannelNumber()).isEqualTo(23);
    }

    @Test
    void shouldExecuteCommandAndUndo() {
        Command command = new ChannelUpCommand();
        Tv tv = new Tv(CURRENT_CHANNEL);
        Remote remote = new Remote();

        remote.changeChannel(command, tv);
        remote.undoLastChange();

        assertThat(tv.getChannelNumber()).isEqualTo(CURRENT_CHANNEL);
    }

    @Test
    void shouldExecuteCommandTwiceAndUndo() {
        Command commandAlpha = new ChannelUpCommand();
        Command commandBravo = new ChannelUpCommand();
        Tv tv = new Tv(CURRENT_CHANNEL);
        Remote remote = new Remote();

        remote.changeChannel(commandAlpha, tv);
        remote.changeChannel(commandBravo, tv);
        remote.undoLastChange();

        assertThat(tv.getChannelNumber()).isEqualTo(CURRENT_CHANNEL + 1);
    }

    @Test
    void shouldNotUnfoIfCommandNotExecuted() {
        Tv tv = new Tv(CURRENT_CHANNEL);
        Remote remote = new Remote();

        remote.undoLastChange();

        assertThat(tv.getChannelNumber()).isEqualTo(CURRENT_CHANNEL);
    }
}