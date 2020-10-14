package com.flaringapp.app;

import com.flaringapp.data.sorting.DrinkSortManagerImpl;
import com.flaringapp.data.sorting.DrinkSortManager;

public final class InstanceResolver {

    public static DrinkSortManager getDrinkSortManager() {
        return new DrinkSortManagerImpl();
    }

}
