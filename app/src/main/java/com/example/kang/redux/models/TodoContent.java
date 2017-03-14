package com.example.kang.redux.models;

/**
 * Created by kang on 17-3-13.
 */
public class TodoContent implements Cloneable {
    public TodoContent(String content, boolean completed) {
        this.content = content;
        this.completed = completed;
    }

    public TodoContent(String content) {
        this.content = content;
        this.completed = false;
    }

    public TodoContent() {
    }

    public String content;
    public boolean completed;

    @Override
    public String toString() {
        return content;
    }

    @Override
    protected TodoContent clone() {
        TodoContent cpy = new TodoContent();
        cpy.content = this.content;
        cpy.completed = this.completed;
        return cpy;
    }
}
