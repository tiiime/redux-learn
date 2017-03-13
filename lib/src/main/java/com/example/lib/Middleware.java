package com.example.lib;

/**
 * Created by kang on 17-3-13.
 */
public interface Middleware<S> {
    IDispatcher dispatch(Store<S> store, IDispatcher nextDispatcher);
}
