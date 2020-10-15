package com.flaringapp.app.inputResolver;

import com.flaringapp.data.models.CoffeeDrink;

import java.util.List;
import java.util.function.Function;

public interface ConsoleInputConsumer {

    void onSort(Function<List<CoffeeDrink>, List<CoffeeDrink>> consumer);

    void onFilter(Function<List<CoffeeDrink>, List<CoffeeDrink>> consumer);

    void onInvalidInput();

}
