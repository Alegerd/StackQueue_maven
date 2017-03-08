package com.app.mainPackage.Classes;

import com.app.mainPackage.Interfaces.IEnumerator;
import com.app.mainPackage.Interfaces.IQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alegerd on 20.02.17.
 */
public class LinkedQueue<T> implements IQueue<T>{

    private List<T> myList = new ArrayList<T>();

    int count = 0;
    public boolean isEmpty = true;

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public void remove() {

            }

            public boolean hasNext() {
                return (myList.get(0) != null);
            }

            public T next() {
                return myList.get(0);
            }
        };
    }

    public void enqueue(T value) {
        count++;
        myList.add(value);
        isEmpty = false;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void clear() {
        myList = new ArrayList<T>();
    }

    public T dequeue() {
        T chosenElement = myList.remove(0);
        count--;
        if(count == 0) isEmpty = true;
        return chosenElement;
    }

    public T peek() {
        if(count != 0) {
            return myList.get(0);
        }
        return null;
    }
}
