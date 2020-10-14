package com.flaringapp.data.sorting;

import com.flaringapp.data.models.CoffeeDrink;

import java.util.List;

public interface DrinkSortManager {

    List<CoffeeDrink> sortByNameAsc(List<CoffeeDrink> drinks);
    List<CoffeeDrink> sortByNameDesc(List<CoffeeDrink> drinks);

    List<CoffeeDrink> sortByCoffeeVolumeAsc(List<CoffeeDrink> drinks);
    List<CoffeeDrink> sortByCoffeeVolumeDesc(List<CoffeeDrink> drinks);

    List<CoffeeDrink> sortByCoffeeSortRatingAsc(List<CoffeeDrink> drinks);
    List<CoffeeDrink> sortByCoffeeSortRatingDesc(List<CoffeeDrink> drinks);

}
