package com.app.mainPackage.Interfaces;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;

/**
 * Created by alegerd on 19.02.17.
 */
public interface IStack<T> extends Iterable<T>{

    //methods
    void push(T value) throws NullObjectSendedException;
    void clear();
    boolean isEmpty();
    T pop() throws OutOfBordersException;
    T peek() throws OutOfBordersException;
}
