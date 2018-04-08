package com.bigos.patterns.adapter;

public class MaleConnectorAdapter implements Pluggable {

    private final MaleConnector maleConnector = new MaleConnector();

    @Override
    public void plug() {
        maleConnector.connect();
    }
}
