package com.example.kang.redux.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kang on 17-3-13.
 */
public class TodoState {

    public TodoFilter filter =TodoFilter.ALL;
    public List<TodoContent> content;

    public TodoState(TodoFilter filter, List<TodoContent> content) {
        this.filter = filter;
        this.content = content;
    }

    public TodoState(TodoState state) {
        this.filter = state.filter;
        this.content = new ArrayList<>();
        for (TodoContent item : state.content) {
            content.add(item.clone());
        }
    }
}
