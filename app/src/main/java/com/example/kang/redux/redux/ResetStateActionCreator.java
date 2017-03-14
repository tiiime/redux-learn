package com.example.kang.redux.redux;

import com.example.lib.AbsActionCreator;

/**
 * Created by kang on 17-3-14.
 */
public class ResetStateActionCreator<T> extends AbsActionCreator<T> {
    public ResetStateActionCreator() {
        super(Actions.ACTION_RESET_STATE);
    }
}
