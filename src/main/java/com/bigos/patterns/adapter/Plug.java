package com.bigos.patterns.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Plug implements Pluggable {

    private Pluggable pluggable;

    @Override
    public void plug() {
        pluggable.plug();
    }
}
