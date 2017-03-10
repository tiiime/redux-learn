package com.example.lib;

/**
 * Created by kang on 17-3-10.
 */
interface IActionCreator<T> {
    Action<T> create(T content);
}
