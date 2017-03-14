package com.example.kang.redux.redux.reducer;

import com.example.kang.redux.models.TodoFilter;
import com.example.lib.Action;
import com.example.lib.IReducer;

import java.util.List;

/**
 * Created by kang on 17-3-13.
 */
public class VisibilityReducer implements IReducer<TodoFilter> {
    @Override
    public TodoFilter reduce(final TodoFilter state, Action action) {
        return state;
    }
}
