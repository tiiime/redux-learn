package com.example.lib;

/**
 * Created by kang on 17-3-11.
 */
public interface Store<S> {
	S getState();
	void dispatch(Action action);

	void subscribe();
	void unSubscribe();
}
