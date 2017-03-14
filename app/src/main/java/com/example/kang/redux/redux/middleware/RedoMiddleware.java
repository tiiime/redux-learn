package com.example.kang.redux.redux.middleware;

import com.example.kang.redux.models.TodoState;
import com.example.kang.redux.redux.Actions;
import com.example.kang.redux.redux.NotRecordActionCreator;
import com.example.lib.Action;
import com.example.lib.IDispatcher;
import com.example.lib.Middleware;
import com.example.lib.Store;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by kang on 17-3-14.
 */
public class RedoMiddleware implements Middleware<TodoState> {
    private Stack<TodoState> redoStack = new Stack<>();
    private Stack<TodoState> undoStack = new Stack<>();

    NotRecordActionCreator<TodoState> notRecordActionCreator = new NotRecordActionCreator<>();

    @Override
    public IDispatcher create(final Store<TodoState> store, final IDispatcher nextDispatcher) {
        return new IDispatcher() {
            @Override
            public void dispatch(Action action) {
                switch (action.type) {
                    case Actions.ACTION_UNDO_TODO:
                        TodoState undoState = undoStack.pop();
                        redoStack.add(undoState);
                        store.dispatch(notRecordActionCreator.create(undoState));
                        break;
                    case Actions.ACTION_REDO_TODO:
                        TodoState redoState = redoStack.pop();
                        store.dispatch(notRecordActionCreator.create(redoState));
                        break;
                    case Actions.ACTION_NOT_RECORD:
                        nextDispatcher.dispatch(action);
                        break;
                    default:
                        undoStack.add(store.getState());
                        nextDispatcher.dispatch(action);
                }
            }
        };
    }
}
