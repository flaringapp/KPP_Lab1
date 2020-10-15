package com.flaringapp.app;

import com.flaringapp.app.inputResolver.ConsoleInputConsumer;
import com.flaringapp.app.inputResolver.ConsoleInputResolver;
import com.flaringapp.app.interactor.ConsoleInteractor;
import com.flaringapp.data.models.CoffeeDrink;
import com.flaringapp.data.storage.DrinksSourceModel;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class CoffeeDemo implements ConsoleInputConsumer {

    ConsoleInteractor interactor = InstanceResolver.getConsoleInteractor();
    ConsoleInputResolver inputResolver = InstanceResolver.getConsoleInputResolver(this);

    DrinksSourceModel sourceModel = InstanceResolver.getDrinksSourceModel();

    private List<CoffeeDrink> drinks = Collections.emptyList();

    void run() {
        drinks = sourceModel.getDrinks();

        System.out.println("Initial drinks:");
        printDrinks(drinks);

        interactWithUser();
    }

    @Override
    public void onSort(Function<List<CoffeeDrink>, List<CoffeeDrink>> consumer) {
        List<CoffeeDrink> sortedDrinks = consumer.apply(drinks);
        printDrinks(sortedDrinks);
        interactWithUser();
    }

    @Override
    public void onFilter(Function<List<CoffeeDrink>, List<CoffeeDrink>> consumer) {
        List<CoffeeDrink> filteredDrinks = consumer.apply(drinks);
        printDrinks(filteredDrinks);
        interactWithUser();
    }

    @Override
    public void onInvalidInput() {
        System.out.println("Invalid input!\n");
        interactWithUser();
    }

    private void interactWithUser() {
        interactor.askWhatToDo(inputResolver::resolve);
    }

    private void printDrinks(List<CoffeeDrink> drinks) {
        drinks.forEach(System.out::println);
    }
}
