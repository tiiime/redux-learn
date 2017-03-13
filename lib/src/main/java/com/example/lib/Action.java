package com.example.lib;

/**
 * Created by kang on 17-3-10.
 */
public class Action<T> {
    public String type;

    private T content;

    protected Action(String type, T content) {
        this.type = type;
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}
