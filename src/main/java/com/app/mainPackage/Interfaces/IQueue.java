package com.app.mainPackage.Interfaces;

import com.app.mainPackage.Exceptions.OutOfBordersException;

/**
 * Created by alegerd on 19.02.17.
 */
public interface IQueue<T> extends IEnumerable{
    //methods
    void Enqueue(T value);
    void clear();
    boolean isEmpty();
    T Dequeue();
    T peek() throws OutOfBordersException;
}
