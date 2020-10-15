package com.flaringapp.app.interactor;

import com.flaringapp.utils.Callback;

public interface ConsoleInteractor {

    void askWhatToDo(Callback<String> callback);

}
