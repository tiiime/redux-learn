package com.example.lib;

import java.util.List;

/**
 * Created by kang on 17-3-10.
 */
public class Action<T> {
    public String type;
    public List<String> filter;

    private T content;

    protected Action(String type, T content) {
        this(type, null, content);
    }

    protected Action(String type, List<String> filter, T content) {
        this.type = type;
        this.filter = filter;
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}
