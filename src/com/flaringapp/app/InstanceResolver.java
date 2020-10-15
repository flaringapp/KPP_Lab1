package com.flaringapp.app;

import com.flaringapp.app.inputResolver.ConsoleInputConsumer;
import com.flaringapp.app.inputResolver.ConsoleInputResolver;
import com.flaringapp.app.inputResolver.ConsoleInputResolverImpl;
import com.flaringapp.app.interactor.ConsoleInteractor;
import com.flaringapp.app.interactor.ConsoleInteractorImpl;
import com.flaringapp.data.filtering.DrinkFilterManager;
import com.flaringapp.data.filtering.DrinkFilterManagerImpl;
import com.flaringapp.data.sorting.DrinkSortManagerImpl;
import com.flaringapp.data.sorting.DrinkSortManager;
import com.flaringapp.data.storage.DrinksSourceModel;
import com.flaringapp.data.storage.DrinksSourceModelImpl;

public final class InstanceResolver {

    public static ConsoleInteractor getConsoleInteractor() {
        return new ConsoleInteractorImpl();
    }

    public static ConsoleInputResolver getConsoleInputResolver(ConsoleInputConsumer consumer) {
        return new ConsoleInputResolverImpl(consumer);
    }

    public static DrinksSourceModel getDrinksSourceModel() {
        return new DrinksSourceModelImpl();
    }

    public static DrinkSortManager getDrinkSortManager() {
        return new DrinkSortManagerImpl();
    }

    public static DrinkFilterManager getDrinkFilterManager() {
        return new DrinkFilterManagerImpl();
    }

}
