package com.flaringapp.data.storage;

import com.flaringapp.data.models.CoffeeDrink;

import java.util.Collections;
import java.util.List;

public class DrinksSourceModelImpl implements DrinksSourceModel {

    @Override
    public List<CoffeeDrink> getDrinks() {
        return Collections.emptyList();
    }
}
