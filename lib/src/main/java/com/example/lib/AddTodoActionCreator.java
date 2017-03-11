package com.example.lib;

/**
 * Created by kang on 17-3-11.
 */
public class AddTodoActionCreator<T> extends AbsActionCreator<T> {
	public AddTodoActionCreator() {
		super(Actions.ADD_TODO_ACTION);
	}
}
