package com.example.kang.redux.redux.reducer;

import com.example.kang.redux.models.TodoContent;
import com.example.kang.redux.models.TodoFilter;
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
        List<TodoContent> retState = new ArrayList<>(state);
        switch (action.type) {
            case Actions.ADD_TODO_ACTION:
                retState.add((TodoContent) action.getContent());
                return retState;
            case Actions.TOGGLE_TODO_ACTION:
                TodoContent content = retState.get((int) action.getContent());
                if (content.filter == TodoFilter.OVER) {
                    content.filter = TodoFilter.NEW;
                } else if (content.filter == TodoFilter.NEW) {
                    content.filter = TodoFilter.OVER;
                }
                return retState;
            default:
                return state;
        }

    }
}
