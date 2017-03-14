package com.example.kang.redux.redux.middleware;

import com.example.kang.redux.redux.Actions;
import com.example.kang.redux.redux.action.async.AsyncResponseActionCreator;
import com.example.lib.Action;
import com.example.lib.IDispatcher;
import com.example.lib.Middleware;
import com.example.lib.Store;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kang on 17-3-14.
 */
public class ThunkMiddleware implements Middleware {
    @Override
    public IDispatcher create(final Store store, final IDispatcher nextDispatcher) {
        return new IDispatcher() {
            @Override
            public void dispatch(Action action) {
                switch (action.type) {
                    case Actions.ACTION_ASYNC:
                        asyncRequest(store, (Action) action.getContent());
                        break;
                    default:
                        nextDispatcher.dispatch(action);
                }
            }
        };
    }

    private void asyncRequest(final Store store, final Action nextAction) {

        Observable<String> observable = Observable.just("");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        store.dispatch(nextAction);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
