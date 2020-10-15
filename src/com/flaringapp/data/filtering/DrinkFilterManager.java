package com.flaringapp.data.filtering;

import com.flaringapp.data.models.CoffeeDrink;
import com.flaringapp.data.models.CoffeeState;
import com.flaringapp.data.models.coffee.info.CoffeeRoastDegree;

import java.util.List;

public interface DrinkFilterManager {

    List<CoffeeDrink> filterByCoffeeState(List<CoffeeDrink> drinks, CoffeeState state);

    List<CoffeeDrink> filterByCoffeeRoast(List<CoffeeDrink> drinks, CoffeeRoastDegree roastDegree);

}
