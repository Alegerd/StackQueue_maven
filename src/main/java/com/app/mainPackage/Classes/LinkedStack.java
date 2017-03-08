package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IEnumerator;
import com.app.mainPackage.Interfaces.IStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alegerd on 19.02.17.
 */

public class LinkedStack<T> implements IStack<T> {

    private List<T> myList = new ArrayList<T>();
    private int pointer = -1;

    int count = 0;
    boolean isEmpty = true;

    public LinkedStack(){

    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public void remove() {

            }

            public boolean hasNext() {
                return (myList.get(pointer++) != null);
            }

            public T next() {
                return myList.get(pointer++);
            }
        };
    }

    public void push(T value) throws NullObjectSendedException{
        if(value != null) {
            pointer += 1;
            count++;
            myList.add(value);
            isEmpty = false;
        }
        else {
            throw new NullObjectSendedException("Value can't be null");
        }
    }


    public void clear() {
        myList = new ArrayList<T>();
        isEmpty = true;
        pointer = -1;
    }

    public T pop() throws OutOfBordersException{
            T chosenElement = null;
            if (pointer >= 0) {
                chosenElement = myList.remove(pointer);
                pointer--;
                count--;
                return chosenElement;
            }
            else
            {
                isEmpty = true;
                throw new OutOfBordersException("Stack is empty");
            }
    }

    public T peek() throws OutOfBordersException{
        if(pointer >= 0) {
            return myList.get(pointer);
        }
        else {
            throw new OutOfBordersException("Stack is empty");
        }
    }
}
