package com.example.kang.redux.redux;

import com.example.lib.AbsActionCreator;

/**
 * Created by kang on 17-3-13.
 */
public class ToggleTodoActionCreator<T> extends AbsActionCreator<T> {
    public ToggleTodoActionCreator() {
        super(Actions.ACTION_TOGGLE_TODO);
    }
}
