package com.example.kang.redux.redux;

import com.example.lib.AbsActionCreator;
import com.example.lib.Action;

/**
 * Created by kang on 17-3-14.
 */
public class RedoActionCreator {
    public static Action createUndoAction() {
        return new AbsActionCreator<Object>(Actions.ACTION_UNDO_TODO){}.create(new Object());
    }

    public static Action createRedoAction() {
        return new AbsActionCreator<Object>(Actions.ACTION_REDO_TODO){}.create(new Object());
    }
}