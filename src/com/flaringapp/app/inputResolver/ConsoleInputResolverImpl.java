package com.flaringapp.app.inputResolver;

import com.flaringapp.app.InstanceResolver;
import com.flaringapp.data.filtering.DrinkFilterManager;
import com.flaringapp.data.models.CoffeeDrink;
import com.flaringapp.data.models.CoffeeState;
import com.flaringapp.data.models.coffee.info.CoffeeRoastDegree;
import com.flaringapp.data.sorting.DrinkSortManager;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ConsoleInputResolverImpl implements ConsoleInputResolver {

    private static final String SPACE = " ";

    private static final String ASC = "asc";
    private static final String DESC = "desc";

    private static final List<String> ORDERS = Arrays.asList(ASC, DESC);

    private static final List<String> SORT_OPTIONS = Arrays.asList("1", "2", "3");
    private static final List<String> FILTER_OPTIONS = Arrays.asList("4", "5");

    private final DrinkSortManager sortManager = InstanceResolver.getDrinkSortManager();
    private final DrinkFilterManager filterManager = InstanceResolver.getDrinkFilterManager();

    private final ConsoleInputConsumer consumer;

    public ConsoleInputResolverImpl(ConsoleInputConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void resolve(String input) {
        String[] params = input.split(SPACE);

        if (params.length == 0) {
            consumer.onInvalidInput();
            return;
        }

        String option = params[0];

        if (SORT_OPTIONS.contains(option)) {
            resolveSort(params);
        } else if (FILTER_OPTIONS.contains(option)) {
            resolveFilter(params);
        } else {
            consumer.onInvalidInput();
        }
    }

    private void resolveSort(String[] params) {
        if (!isValidSortFormat(params)) {
            consumer.onInvalidInput();
            return;
        }

        String sortTypeParam = params[1];

        boolean isAscending = sortTypeParam.equals(ASC);

        String sortTypeName;
        Function<List<CoffeeDrink>, List<CoffeeDrink>> sortAction;

        switch (params[0]) {
            case "1":
                sortTypeName = "name";
                sortAction = drinks -> isAscending ?
                        sortManager.sortByNameAsc(drinks) :
                        sortManager.sortByNameDesc(drinks);
                break;
            case "2":
                sortTypeName = "coffee volume";
                sortAction = drinks -> isAscending ?
                        sortManager.sortByCoffeeVolumeAsc(drinks) :
                        sortManager.sortByCoffeeVolumeDesc(drinks);
                break;
            case "3":
                sortTypeName = "coffee sort rating";
                sortAction = drinks -> isAscending ?
                        sortManager.sortByCoffeeSortRatingAsc(drinks) :
                        sortManager.sortByCoffeeSortRatingDesc(drinks);
                break;
            default:
                consumer.onInvalidInput();
                return;
        }

        System.out.println("Sort by " + sortTypeName + " " + sortTypeParam);

        consumer.onSort(sortAction);
    }

    private void resolveFilter(String[] params) {
        if (!isValidFilterFormat(params)) {
            consumer.onInvalidInput();
            return;
        }

        String filterParam = params[1];

        String filterTypeName;
        Function<List<CoffeeDrink>, List<CoffeeDrink>> filterAction;

        switch (params[0]) {
            case "4":
                filterTypeName = "coffee state";
                CoffeeState state = CoffeeState.parse(filterParam);
                if (state == null) {
                    consumer.onInvalidInput();
                    return;
                }
                filterAction = drinks -> filterManager.filterByCoffeeState(drinks, state);
                break;
            case "5":
                filterTypeName = "coffee roast";
                CoffeeRoastDegree roast = CoffeeRoastDegree.parse(filterParam);
                if (roast == null) {
                    consumer.onInvalidInput();
                    return;
                }
                filterAction = drinks -> filterManager.filterByCoffeeRoast(drinks, roast);
                break;
            default:
                consumer.onInvalidInput();
                return;
        }

        System.out.println("Filter by " + filterTypeName + " (" + filterParam + ")");

        consumer.onFilter(filterAction);
    }

    private boolean isValidSortFormat(String[] params) {
        if (params.length != 2) return false;

        String order = params[1];
        return ORDERS.contains(order);
    }


    private boolean isValidFilterFormat(String[] params) {
        return params.length == 2;
    }

}
