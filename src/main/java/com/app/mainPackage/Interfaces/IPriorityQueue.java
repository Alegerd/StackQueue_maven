package com.app.mainPackage.Interfaces;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;

/**
 * Created by alegerd on 08.03.17.
 */

public interface IPriorityQueue<T,T2 extends Comparable> {
    void enqueue (T value, T2 priority) throws NullObjectSendedException;
    T dequeue() throws OutOfBordersException;
    boolean isEmpty();
}
