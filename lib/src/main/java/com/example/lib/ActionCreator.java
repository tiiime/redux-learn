package com.example.lib;

import java.util.List;

/**
 * Created by kang on 17-3-10.
 */
public class ActionCreator<T> implements IActionCreator<T> {
    private String type;
    private List<String> filter;

    public ActionCreator(String type) {
        this(type, null);
    }

    public ActionCreator(String type, List<String> filter) {
        this.type = type;
        this.filter = filter;
    }

    @Override
    public Action<T> create(T content) {
        return new Action<T>(type, filter, content);
    }
}
