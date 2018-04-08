package com.bigos.patterns.chain;

import lombok.Setter;

public abstract class AbstractLogger {

    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    @Setter
    private AbstractLogger nextLogger;

    protected int level;

    public void receiveRequest(int level, String message) {
        if (this.level <= level) {
            handleRequest(message);
        }

        if (nextLogger != null) {
            nextLogger.receiveRequest(level, message);
        }
    }

    abstract protected void handleRequest(String message);
}
