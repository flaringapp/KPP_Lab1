package com.flaringapp.data.models;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;

public enum CoffeeState {
    GROUND("ground"),
    INSTANT("instant");

    public final String key;

    CoffeeState(String key) {
        this.key = key;
    }

    @Nullable
    public static CoffeeState parse(String key) {
        return Arrays.stream(values())
                .filter(state -> state.key.equals(key))
                .findAny()
                .orElse(null);
    }
}
