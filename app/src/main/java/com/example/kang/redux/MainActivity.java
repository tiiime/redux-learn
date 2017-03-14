package com.example.kang.redux;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.kang.redux.adapter.SimpleAdapter;
import com.example.kang.redux.models.TodoContent;
import com.example.kang.redux.models.TodoFilter;
import com.example.kang.redux.models.TodoState;
import com.example.kang.redux.redux.action.AddTodoActionCreator;
import com.example.kang.redux.redux.action.DeleteTodoActionCreator;
import com.example.kang.redux.redux.action.RedoActionCreator;
import com.example.kang.redux.redux.action.ToggleTodoActionCreator;
import com.example.kang.redux.redux.action.async.AsyncResponseActionCreator;
import com.example.kang.redux.redux.action.async.SimpleAsyncActionCreator;
import com.example.kang.redux.redux.middleware.LoggerMiddleware;
import com.example.kang.redux.redux.middleware.RedoMiddleware;
import com.example.kang.redux.redux.middleware.ThunkMiddleware;
import com.example.kang.redux.redux.reducer.TodoAppReducer;
import com.example.lib.Action;
import com.example.lib.IReducer;
import com.example.lib.Store;
import com.example.lib.Subscriber;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements Subscriber, SimpleAdapter.OnItemClick, View.OnClickListener {
    private TodoState state = new TodoState(TodoFilter.ALL, new ArrayList<TodoContent>());

    private final IReducer<TodoState> reducer = new TodoAppReducer();
    private final LoggerMiddleware loggerMiddleware = new LoggerMiddleware();
    private final RedoMiddleware redoMiddleware = new RedoMiddleware();
    private final Store<TodoState> store = Store.create(state, reducer, loggerMiddleware, redoMiddleware);

    private AddTodoActionCreator<TodoContent> addTodo = new AddTodoActionCreator<>();
    private DeleteTodoActionCreator<Integer> delTodo = new DeleteTodoActionCreator<>();
    private ToggleTodoActionCreator<Integer> toggleTodo = new ToggleTodoActionCreator<>();

    private final SimpleAdapter adapter = new SimpleAdapter(store.getState().content);

    private View add;
    private View undo;
    private View redo;
    private TextView hello;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        undo = findViewById(R.id.undo);
        redo = findViewById(R.id.redo);
        hello = (TextView) findViewById(R.id.hello);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setListener(this);

        add.setOnClickListener(this);
        redo.setOnClickListener(this);
        undo.setOnClickListener(this);
    }

    @Override
    public void onStateUpdate() {
        adapter.reloadData(store.getState().content);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onItemToggle(int position) {
        store.dispatch(toggleTodo.create(position));
    }

    @Override
    public void onItemDelete(int position) {
        store.dispatch(delTodo.create(position));
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

    @Override
    public void onClick(View v) {
        Action action = null;
        switch (v.getId()) {
            case R.id.add:
                String content = hello.getText().toString();
                TodoContent todoContent = new TodoContent(content);
                action = addTodo.create(todoContent);
                break;
            case R.id.redo:
                action = RedoActionCreator.createRedoAction();
                break;
            case R.id.undo:
                action = RedoActionCreator.createUndoAction();
                break;
            case R.id.activity_main:
                SimpleAsyncActionCreator<Action> asyncActionCreator = new SimpleAsyncActionCreator<>();
                AsyncResponseActionCreator nextAction = new AsyncResponseActionCreator();
                action = asyncActionCreator.create(nextAction.create(""));
                break;
        }
        store.dispatch(action);
    }
}
