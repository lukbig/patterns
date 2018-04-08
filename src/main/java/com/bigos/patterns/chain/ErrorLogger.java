package com.bigos.patterns.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void handleRequest(String message) {
        log.error(message);
    }
}
