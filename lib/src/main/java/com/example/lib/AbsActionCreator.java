package com.example.lib;

import java.util.List;

/**
 * Created by kang on 17-3-10.
 */
public abstract class AbsActionCreator<T> implements IActionCreator<T> {
    private String type;

    public AbsActionCreator(String type) {
        this.type = type;
    }

    @Override
    public Action<T> create(T content) {
        return new Action<T>(type, content);
    }
}
