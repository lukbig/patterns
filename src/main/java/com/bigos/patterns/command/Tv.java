package com.bigos.patterns.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tv {

    private int channelNumber;

    @Override
    public String toString() {
        return "Tv";
    }
}
