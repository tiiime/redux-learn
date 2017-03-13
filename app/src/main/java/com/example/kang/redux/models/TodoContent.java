package com.example.kang.redux.models;

/**
 * Created by kang on 17-3-13.
 */
public class TodoContent {
    public TodoContent(String content, TodoFilter filter) {
        this.content = content;
        this.filter = filter;
    }

    public TodoContent(String content) {
        this.content = content;
        this.filter = TodoFilter.NEW;
    }

    public TodoContent() {
    }

    public String content;
    public TodoFilter filter;

    @Override
    public String toString() {
        return content;
    }
}
