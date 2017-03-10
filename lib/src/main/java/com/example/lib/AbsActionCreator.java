package com.example.lib;

import java.util.List;

/**
 * Created by kang on 17-3-10.
 */
public abstract class AbsActionCreator<T> implements IActionCreator<T> {
    private String type;
    private List<String> filter;

    public AbsActionCreator(String type) {
        this(type, null);
    }

    public AbsActionCreator(String type, List<String> filter) {
        this.type = type;
        this.filter = filter;
    }

    @Override
    public Action<T> create(T content) {
        return new Action<T>(type, filter, content);
    }
}
