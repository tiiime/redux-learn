package com.example.kang.redux.redux.middleware;

import com.example.kang.redux.models.TodoState;
import com.example.lib.Action;
import com.example.lib.IDispatcher;
import com.example.lib.Middleware;
import com.example.lib.Store;

/**
 * Created by kang on 17-3-13.
 */
public class LoggerMiddleware implements Middleware<TodoState> {
    @Override
    public IDispatcher dispatch(Store<TodoState> store, final IDispatcher nextDispatcher) {

        return new IDispatcher() {
            @Override
            public void dispatch(Action action) {
                System.out.println(action);
                nextDispatcher.dispatch(action);
            }
        };
    }
}
