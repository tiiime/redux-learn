package com.example.lib;

/**
 * Created by kang on 17-3-10.
 */
public interface IReducer<S> {
	S reduce(S state, Action action);

	class Reducer<S> implements IReducer<S> {
		@Override
		public S reduce(S state, Action action) {
			return state;
		}
	}
}
