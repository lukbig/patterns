package com.bigos.patterns.state;

import lombok.Getter;

public class State {

    @Getter
    private int state = 0;

    public void pull() {
        if (state == 0) {
            state = 1;
        } else if (state == 1) {
            state = 2;
        } else {
            state = 0;
        }
    }
}
