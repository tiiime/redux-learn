package com.example.lib;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Store<Object> store = new Store<Object>() {
            @Override
            public Object getState() {
                return null;
            }

            @Override
            public void dispatch(Action action) {

            }

            @Override
            public void subscribe() {

            }

            @Override
            public void unSubscribe() {

            }
        };

        AddTodoActionCreator<String> creator = new AddTodoActionCreator<>();
        Action action = creator.create("dsa)");
        store.dispatch(action);

        assertEquals(4, 2 + 2);
    }
}