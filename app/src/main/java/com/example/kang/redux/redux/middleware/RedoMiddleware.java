package com.example.kang.redux.redux.middleware;

import com.example.kang.redux.models.TodoState;
import com.example.kang.redux.redux.Actions;
import com.example.kang.redux.redux.action.ResetStateActionCreator;
import com.example.lib.Action;
import com.example.lib.IDispatcher;
import com.example.lib.Middleware;
import com.example.lib.Store;

import java.util.Stack;

/**
 * Created by kang on 17-3-14.
 */
public class RedoMiddleware implements Middleware<TodoState> {
    private Stack<TodoState> redoStack = new Stack<>();
    private Stack<TodoState> undoStack = new Stack<>();

    ResetStateActionCreator<TodoState> resetStateActionCreator = new ResetStateActionCreator<>();

    @Override
    public IDispatcher create(final Store<TodoState> store, final IDispatcher nextDispatcher) {
        return new IDispatcher() {
            @Override
            public void dispatch(Action action) {
                switch (action.type) {
                    case Actions.ACTION_UNDO_TODO:
                        try {
                            TodoState undoState = undoStack.pop();
                            redoStack.add(new TodoState(store.getState()));
                            store.dispatch(resetStateActionCreator.create(undoState));
                        } catch (Exception e) {
//                            e.printStackTrace();
                        }
                        break;
                    case Actions.ACTION_REDO_TODO:
                        try {
                            TodoState redoState = redoStack.pop();
                            undoStack.add(new TodoState(store.getState()));
                            store.dispatch(resetStateActionCreator.create(redoState));
                        } catch (Exception e) {
//                            e.printStackTrace();
                        }
                        break;
                    case Actions.ACTION_RESET_STATE:
                        nextDispatcher.dispatch(action);
                        break;
                    default:
                        undoStack.add(new TodoState(store.getState()));
                        nextDispatcher.dispatch(action);
                }
            }
        };
    }
}
