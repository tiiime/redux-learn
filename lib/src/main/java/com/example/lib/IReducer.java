package com.example.lib;

/**
 * Created by kang on 17-3-10.
 */
public interface IReducer<S extends State, A extends Action> {
	S reduce(S state, A action);

	class Reducer<S extends State, A extends Action> implements IReducer<S, A> {
		@Override
		public S reduce(S state, A action) {
			return state;
		}
	}
}
