package com.bigos.patterns.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void handleRequest(String message) {
        log.debug(message);
    }
}
