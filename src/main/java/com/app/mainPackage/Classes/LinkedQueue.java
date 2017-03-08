package com.app.mainPackage.Classes;

import com.app.mainPackage.Interfaces.IEnumerator;
import com.app.mainPackage.Interfaces.IQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alegerd on 20.02.17.
 */
public class LinkedQueue<T> implements IQueue<T>{

    private List<T> myList = new ArrayList<T>();

    int count = 0;
    public boolean isEmpty = true;

    public LinkedQueue(){
    }

    public IEnumerator getEnumerator() {
        return new IEnumerator() {
            public boolean MoveNext() {
                return false;
            }

            public void Reset() {

            }

            public Object getCurrent() {
                return Dequeue();
            }
        };
    }

    public void Enqueue(T value) {
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

    public T Dequeue() {
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
