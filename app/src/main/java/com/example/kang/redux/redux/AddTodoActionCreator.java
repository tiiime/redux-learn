package com.example.kang.redux.redux;

import com.example.lib.AbsActionCreator;

/**
 * Created by kang on 17-3-11.
 */
public class AddTodoActionCreator<T> extends AbsActionCreator<T> {
	public AddTodoActionCreator() {
		super(Actions.ADD_TODO_ACTION);
	}
}
