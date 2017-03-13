package com.example.kang.redux.redux.reducer;

import com.example.kang.redux.models.TodoContent;
import com.example.lib.Action;
import com.example.lib.IReducer;

import java.util.List;

/**
 * Created by kang on 17-3-13.
 */
public class TodoReducer implements IReducer<List<TodoContent>>{
    @Override
    public List<TodoContent> reduce(List<TodoContent> state, Action action) {
        return state;
    }
}
