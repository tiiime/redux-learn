package com.example.kang.redux.redux.action.async;

import com.example.kang.redux.redux.Actions;
import com.example.kang.redux.redux.middleware.ThunkMiddleware;
import com.example.lib.AbsActionCreator;
import io.reactivex.Observable;

/**
 * Created by kang on 17-3-14.
 */
public class SimpleAsyncActionCreator<T> extends AbsActionCreator<T> {
    public SimpleAsyncActionCreator() {
        super(Actions.ACTION_ASYNC);
    }
}
