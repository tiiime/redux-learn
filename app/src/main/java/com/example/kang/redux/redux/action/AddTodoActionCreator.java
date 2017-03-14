package com.example.kang.redux.redux.action;

import com.example.kang.redux.redux.Actions;
import com.example.lib.AbsActionCreator;

/**
 * Created by kang on 17-3-11.
 */
public class AddTodoActionCreator<T> extends AbsActionCreator<T> {
	public AddTodoActionCreator() {
		super(Actions.ACTION_ADD_TODO);
	}
}
