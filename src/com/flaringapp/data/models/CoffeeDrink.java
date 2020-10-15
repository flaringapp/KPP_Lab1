package com.flaringapp.data.models;

import com.flaringapp.data.formatters.CoffeeRoastFormatter;
import com.flaringapp.data.formatters.CoffeeStateFormatter;
import com.flaringapp.data.models.coffee.info.CoffeeInfo;

public class CoffeeDrink {

    private final String name;
    private final CoffeeInfo coffeeInfo;
    private final CoffeeState coffeeState;
    private final int coffeeVolume;

    public CoffeeDrink(String name, CoffeeInfo coffeeInfo, CoffeeState coffeeState, int coffeeVolume) {
        this.name = name;
        this.coffeeInfo = coffeeInfo;
        this.coffeeState = coffeeState;
        this.coffeeVolume = coffeeVolume;
    }

    public String getName() {
        return name;
    }

    public CoffeeInfo getCoffeeInfo() {
        return coffeeInfo;
    }

    public CoffeeState getCoffeeState() {
        return coffeeState;
    }

    public int getCoffeeVolume() {
        return coffeeVolume;
    }

    @Override
    public String toString() {
        return name +
                " | " +
                coffeeVolume +
                "ml" +
                " | " +
                CoffeeStateFormatter.formatCoffeeState(coffeeState) +
                " | " +
                coffeeInfo.getSort().getRating() +
                " rating (" +
                coffeeInfo.getSort().getName() +
                ")" +
                " | " +
                "Roast: " +
                CoffeeRoastFormatter.formatCoffeeRoastDegree(coffeeInfo.getRoastDegree());
    }
}
