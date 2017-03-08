package com.app.mainPackage.Interfaces;

/**
 * Created by alegerd on 08.03.17.
 */

public interface IPriorityQueue<T,T2 extends Comparable> {
    void enqueue (T value, T2 priority);
    void dequeue();
    boolean isEmpty();
}
