package com.flaringapp.data.formatters;

import com.flaringapp.data.models.CoffeeState;

public class CoffeeStateFormatter {

    public static String formatCoffeeState(CoffeeState state) {
        String name;
        switch (state) {
            case GROUND:
                name = "Ground coffee";
                break;
            case INSTANT:
                name = "Instant coffee";
                break;
            default:
                throw new IllegalStateException("Coffee state formatter does not support state " + state.name());
        }
        return name;
    }

}
