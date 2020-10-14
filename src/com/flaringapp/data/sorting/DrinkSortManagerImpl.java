package com.flaringapp.data.sorting;

import com.flaringapp.data.models.CoffeeDrink;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DrinkSortManagerImpl implements DrinkSortManager {

    @Override
    public List<CoffeeDrink> sortByNameAsc(List<CoffeeDrink> drinks) {
        @SuppressWarnings("Convert2Lambda")
        Comparator<CoffeeDrink> comparator = new Comparator<CoffeeDrink>() {
            @Override
            public int compare(CoffeeDrink first, CoffeeDrink second) {
                return String.CASE_INSENSITIVE_ORDER.compare(first.getName(), second.getName());
            }
        };

        return copyAndSort(drinks, comparator);
    }

    @Override
    public List<CoffeeDrink> sortByNameDesc(List<CoffeeDrink> drinks) {
        return copyAndSort(
                drinks,
                (first, second) -> String.CASE_INSENSITIVE_ORDER.compare(first.getName(), second.getName())
        );
    }

    @Override
    public List<CoffeeDrink> sortByCoffeeVolumeAsc(List<CoffeeDrink> drinks) {
        return copyAndSort(drinks, new CoffeeVolumeComparator());
    }

    @Override
    public List<CoffeeDrink> sortByCoffeeVolumeDesc(List<CoffeeDrink> drinks) {
        return copyAndSort(drinks, new CoffeeVolumeComparator().reversed());
    }

    @Override
    public List<CoffeeDrink> sortByCoffeeSortRatingAsc(List<CoffeeDrink> drinks) {
        return copyAndSort(drinks, new CoffeeRatingComparator());
    }

    @Override
    public List<CoffeeDrink> sortByCoffeeSortRatingDesc(List<CoffeeDrink> drinks) {
        return copyAndSort(drinks, new CoffeeRatingComparator().reversed());
    }

    private <T> List<T> copyAndSort(List<T> items, Comparator<T> comparator) {
        List<T> sortedList = new ArrayList<>(items);
        sortedList.sort(comparator);
        return sortedList;
    }

    private static class CoffeeVolumeComparator implements Comparator<CoffeeDrink> {
        @Override
        public int compare(CoffeeDrink first, CoffeeDrink second) {
            return Integer.compare(first.getCoffeeVolume(), second.getCoffeeVolume());
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class CoffeeRatingComparator implements Comparator<CoffeeDrink> {
        @Override
        public int compare(CoffeeDrink first, CoffeeDrink second) {
            return Integer.compare(
                    first.getCoffeeInfo().getSort().getRating(),
                    second.getCoffeeInfo().getSort().getRating()
            );
        }
    }

}
