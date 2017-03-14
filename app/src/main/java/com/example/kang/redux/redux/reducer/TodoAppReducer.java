package com.example.kang.redux.redux.reducer;

import com.example.kang.redux.models.TodoContent;
import com.example.kang.redux.models.TodoFilter;
import com.example.kang.redux.models.TodoState;
import com.example.kang.redux.redux.Actions;
import com.example.lib.Action;
import com.example.lib.IReducer;

import java.util.List;

/**
 * Created by kang on 17-3-13.
 */
public class TodoAppReducer implements IReducer<TodoState> {
    private TodoReducer todoReducer = new TodoReducer();
    private VisibilityReducer visibilityReducer = new VisibilityReducer();

    @Override
    public TodoState reduce(TodoState state, Action action) {
        switch (action.type){
            case Actions.ACTION_NOT_RECORD:
                return (TodoState) action.getContent();
            default:
                List<TodoContent> contents = todoReducer.reduce(state.content,action);
                TodoFilter filter = visibilityReducer.reduce(state.filter,action);
                return new TodoState(filter,contents);
        }


    }
}
