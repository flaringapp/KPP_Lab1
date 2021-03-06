package com.flaringapp.data.models.coffee.info;

public class CoffeeInfo {

    private final CoffeeSort sort;
    private final CoffeeRoastDegree roastDegree;

    public CoffeeInfo(CoffeeSort sort, CoffeeRoastDegree roastDegree) {
        this.sort = sort;
        this.roastDegree = roastDegree;
    }

    public CoffeeSort getSort() {
        return sort;
    }

    public CoffeeRoastDegree getRoastDegree() {
        return roastDegree;
    }

}
