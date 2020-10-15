package com.flaringapp.app.interactor;

import com.flaringapp.utils.Callback;

import java.util.Scanner;

public class ConsoleInteractorImpl implements ConsoleInteractor {

    Scanner scanner = new Scanner(System.in);

    private static final String options = "\n" +
            "1. Sort by name\n" +
            "2. Sort by coffee volume\n" +
            "3. Sort by coffee sort rating\n" +
            "4. Filter by coffee state\n" +
            "5. Filter by coffee roast\n\n" +
            "Syntax:\n" +
            "- Sort: <number> <order>. Order can be \"asc\" or \"desc\")\n" +
            "- Filter: <number> <param>.\n";

    @Override
    public void askWhatToDo(Callback<String> callback) {
        System.out.println(options);
        String input = scanner.nextLine();
        callback.call(input);
    }

}
