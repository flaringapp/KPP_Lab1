package com.flaringapp.data.models.coffee.info;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;

public enum CoffeeRoastDegree {
    LIGHT("light"),
    MEDIUM("medium"),
    MEDIUM_DARK("medium_dark"),
    DARK("dark"),
    VERY_DARK("very_dark");

    private final String key;

    CoffeeRoastDegree(String key) {
        this.key = key;
    }

    @Nullable
    public static CoffeeRoastDegree parse(String key) {
        return Arrays.stream(values())
                .filter(state -> state.key.equals(key))
                .findAny()
                .orElse(null);
    }
}
