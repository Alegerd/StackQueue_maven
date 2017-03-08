package com.app.mainPackage.Interfaces;

import com.app.mainPackage.Exceptions.OutOfBordersException;

/**
 * Created by alegerd on 19.02.17.
 */
public interface IQueue<T> extends Iterable<T>{
    //methods
    void enqueue(T value);
    void clear();
    boolean isEmpty();
    T dequeue();
    T peek() throws OutOfBordersException;
}
