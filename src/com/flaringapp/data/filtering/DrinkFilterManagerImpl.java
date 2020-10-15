package com.flaringapp.data.filtering;

import com.flaringapp.data.models.CoffeeDrink;
import com.flaringapp.data.models.CoffeeState;
import com.flaringapp.data.models.coffee.info.CoffeeRoastDegree;

import java.util.List;
import java.util.stream.Collectors;

public class DrinkFilterManagerImpl implements DrinkFilterManager {

    @Override
    public List<CoffeeDrink> filterByCoffeeState(List<CoffeeDrink> drinks, CoffeeState state) {
        return drinks.stream()
                .filter(drink -> drink.getCoffeeState() == state)
                .collect(Collectors.toList());
    }

    @Override
    public List<CoffeeDrink> filterByCoffeeRoast(List<CoffeeDrink> drinks, CoffeeRoastDegree roastDegree) {
        return drinks.stream()
                .filter(drink -> drink.getCoffeeInfo().getRoastDegree() == roastDegree)
                .collect(Collectors.toList());
    }
}
