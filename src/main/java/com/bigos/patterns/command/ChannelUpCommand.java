package com.bigos.patterns.command;

public class ChannelUpCommand implements Command {

    private Tv tv;
    private int currentChannel;

    @Override
    public void execute(Tv tv) {
        this.tv = tv;
        this.currentChannel = tv.getChannelNumber();
        tv.setChannelNumber(currentChannel + 1);
    }

    @Override
    public void undo() {
        if (tv != null) {
            tv.setChannelNumber(currentChannel);
        }
    }

    @Override
    public String toString() {
        return "Channel up commmand";
    }
}
