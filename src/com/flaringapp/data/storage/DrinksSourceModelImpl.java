package com.flaringapp.data.storage;

import com.flaringapp.data.models.CoffeeDrink;
import com.flaringapp.data.models.CoffeeState;
import com.flaringapp.data.models.coffee.info.CoffeeInfo;
import com.flaringapp.data.models.coffee.info.CoffeeRoastDegree;
import com.flaringapp.data.models.coffee.sort.CoffeeSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DrinksSourceModelImpl implements DrinksSourceModel {

    private static final CoffeeSort SORT_ETHIOPIA = new CoffeeSort(
            "Ethiopia Aricha",
            89
    );

    private static final CoffeeSort SORT_COSTA_RICA = new CoffeeSort(
            "Costa Rica",
            87
    );

    private static final CoffeeSort SORT_UNKNOWN = new CoffeeSort(
            "Unknown",
            0
    );

    private static final List<CoffeeDrink> MOCKUP = Arrays.asList(
            new CoffeeDrink(
                    "Espresso Tonic",
                    new CoffeeInfo(
                            SORT_ETHIOPIA,
                            CoffeeRoastDegree.MEDIUM_DARK
                    ),
                    CoffeeState.GROUND,
                    40
            ),
            new CoffeeDrink(
                    "Espresso",
                    new CoffeeInfo(
                            SORT_ETHIOPIA,
                            CoffeeRoastDegree.DARK
                    ),
                    CoffeeState.GROUND,
                    25
            ),
            new CoffeeDrink(
                    "Doppio",
                    new CoffeeInfo(
                            SORT_ETHIOPIA,
                            CoffeeRoastDegree.DARK
                    ),
                    CoffeeState.GROUND,
                    50
            ),
            new CoffeeDrink(
                    "Chemex",
                    new CoffeeInfo(
                            SORT_COSTA_RICA,
                            CoffeeRoastDegree.LIGHT
                    ),
                    CoffeeState.GROUND,
                    420
            ),
            new CoffeeDrink(
                    "Cheap hot coffee",
                    new CoffeeInfo(
                            SORT_UNKNOWN,
                            CoffeeRoastDegree.MEDIUM
                    ),
                    CoffeeState.INSTANT,
                    340
            )
    );

    @Override
    public List<CoffeeDrink> getDrinks() {
        return MOCKUP;
    }
}
