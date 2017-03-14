package com.example.kang.redux.redux.action.async;

import com.example.kang.redux.redux.Actions;
import com.example.lib.AbsActionCreator;

/**
 * Created by kang on 17-3-14.
 */
public class AsyncResponseActionCreator extends AbsActionCreator<String> {
    public AsyncResponseActionCreator() {
        super(Actions.ACTION_ASYNC);
    }
}
