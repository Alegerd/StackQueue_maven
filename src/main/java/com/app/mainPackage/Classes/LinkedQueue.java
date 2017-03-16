package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IEnumerator;
import com.app.mainPackage.Interfaces.IQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alegerd on 20.02.17.
 */
public class LinkedQueue<T> implements IQueue<T>{

    private List<T> myList = new LinkedList<T>();

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

    public void enqueue(T value) throws NullObjectSendedException{
        if(value != null) {
            count++;
            myList.add(value);
            isEmpty = false;
        }
        else {
            throw new NullObjectSendedException("Value can't be null");
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void clear() {
        myList = new LinkedList<T>();
    }

    public T dequeue() throws OutOfBordersException{
        if(count == 0)
        {
            isEmpty = true;
            throw new OutOfBordersException("Queue is empty");
        }
        else {
            T chosenElement = myList.remove(0);
            count--;
            isEmpty = (count == 0)?  true: false;

            return chosenElement;
        }
    }

    public T peek() throws OutOfBordersException{
        if(count != 0) {
            return myList.get(0);
        }
        else {
            throw new OutOfBordersException("Queue is empty");
        }
    }
}
