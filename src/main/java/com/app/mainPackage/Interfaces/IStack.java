package com.app.mainPackage.Interfaces;

/**
 * Created by alegerd on 19.02.17.
 */
public interface IStack<T> extends Iterable<T>{

    //methods
    void push(T value);
    void clear();
    boolean isEmpty();
    T pop();
    T peek();
}
