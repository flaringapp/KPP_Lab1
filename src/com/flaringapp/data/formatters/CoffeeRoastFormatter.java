package com.flaringapp.data.formatters;

import com.flaringapp.data.models.coffee.info.CoffeeRoastDegree;

public class CoffeeRoastFormatter {

    public static String formatCoffeeRoastDegree(CoffeeRoastDegree degree) {
        String name;
        switch (degree) {
            case LIGHT:
                name = "Light";
                break;
            case MEDIUM:
                name = "Medium";
                break;
            case MEDIUM_DARK:
                name = "Medium dark";
                break;
            case DARK:
                name = "Dark";
                break;
            case VERY_DARK:
                name = "Very dark";
                break;
            default:
                throw new IllegalStateException("Coffee roast degree formatter does not support degree " + degree.name());
        }
        return name;
    }
}
