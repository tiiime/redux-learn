package com.example.kang.redux;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.TextView;
import com.example.kang.redux.models.TodoContent;
import com.example.kang.redux.models.TodoFilter;
import com.example.kang.redux.models.TodoState;
import com.example.kang.redux.redux.AddTodoActionCreator;
import com.example.kang.redux.redux.middleware.LoggerMiddleware;
import com.example.kang.redux.redux.reducer.TodoAppReducer;
import com.example.lib.IReducer;
import com.example.lib.Store;
import com.example.lib.Subscriber;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Subscriber {
    private TodoState state = new TodoState(TodoFilter.ALL, new ArrayList<TodoContent>());

    private final IReducer<TodoState> reducer = new TodoAppReducer();
    private final LoggerMiddleware loggerMiddleware = new LoggerMiddleware();
    private final Store<TodoState> store = Store.create(state, reducer, loggerMiddleware);

    private AddTodoActionCreator<TodoContent> addTodo = new AddTodoActionCreator<>();

    private TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = (TextView) findViewById(R.id.hello);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            TodoContent content = new TodoContent();
            content.content = System.currentTimeMillis() + "";
            content.filter = TodoFilter.NEW;

            store.dispatch(addTodo.create(content));
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void onStateUpdate() {
        StringBuilder builder = new StringBuilder();
        for (TodoContent content : store.getState().content) {
            builder.append(content.content);
            builder.append('\n');
        }
        hello.setText(builder.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        store.subscribe(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        store.unSubscribe(this);
    }
}
