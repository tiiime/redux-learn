package com.example.kang.redux.redux.reducer;

import com.example.kang.redux.models.TodoContent;
import com.example.kang.redux.redux.Actions;
import com.example.lib.Action;
import com.example.lib.IReducer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kang on 17-3-13.
 */
public class TodoReducer implements IReducer<List<TodoContent>>{
    @Override
    public List<TodoContent> reduce(List<TodoContent> state, Action action) {

        switch (action.type) {
            case Actions.ADD_TODO_ACTION:
                List<TodoContent> retState = new ArrayList<>(state);
                retState.add((TodoContent) action.getContent());
                return retState;
            default:
                return state;
        }

    }
}
