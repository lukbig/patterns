package com.bigos.patterns.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void handleRequest(String message) {
        log.info(message);
    }
}
