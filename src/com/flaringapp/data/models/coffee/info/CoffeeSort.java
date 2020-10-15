package com.flaringapp.data.models.coffee.info;

public class CoffeeSort {

    private static final int SPECIALTY_MIN_RATE = 80;

    private final String name;
    private final int rating;

    public CoffeeSort(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public boolean isSpecialty() {
        return rating >= SPECIALTY_MIN_RATE;
    }

}
