package com.example.kang.redux.redux.action;

import com.example.kang.redux.redux.Actions;
import com.example.lib.AbsActionCreator;

/**
 * Created by kang on 17-3-13.
 */
public class DeleteTodoActionCreator<T> extends AbsActionCreator<T> {
    public DeleteTodoActionCreator() {
        super(Actions.ACTION_DELETE_TODO);
    }
}
