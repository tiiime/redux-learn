package com.example.kang.redux.redux;

import com.example.lib.AbsActionCreator;

/**
 * Created by kang on 17-3-14.
 */
public class NotRecordActionCreator<T> extends AbsActionCreator<T> {
    public NotRecordActionCreator() {
        super(Actions.ACTION_NOT_RECORD);
    }
}
