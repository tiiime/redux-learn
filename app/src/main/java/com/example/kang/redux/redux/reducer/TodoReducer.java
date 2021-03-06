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
    public List<TodoContent> reduce(final List<TodoContent> state, Action action) {
        List<TodoContent> retState = new ArrayList<>(state);
        switch (action.type) {
            case Actions.ACTION_ADD_TODO:
                retState.add((TodoContent) action.getContent());
                break;
            case Actions.ACTION_TOGGLE_TODO:
                TodoContent content = retState.get((int) action.getContent());
                content.completed = !content.completed;
                break;
            case Actions.ACTION_DELETE_TODO:
                retState.remove((int) action.getContent());
                break;
            default:
                return state;
        }
        return retState;
    }
}
