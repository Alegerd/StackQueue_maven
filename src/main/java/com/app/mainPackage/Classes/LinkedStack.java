package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IEnumerator;
import com.app.mainPackage.Interfaces.IStack;

import java.util.ArrayList;
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

    public IEnumerator getEnumerator() {
        return new IEnumerator() {
            public boolean MoveNext() {
                return false;
            }

            public void Reset() {

            }

            public Object getCurrent() {
                return pop();
            }
        };
    }
    public void push(T value) {
        pointer+=1;
        count++;
        myList.add(value);
        isEmpty = false;
    }


    public void clear() {
        myList = new ArrayList<T>();
        isEmpty = true;
        pointer = -1;
    }

    public T pop() {
        try {
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
                throw new OutOfBordersException("the list is empty");
            }

        }
        catch(OutOfBordersException ex)
            {
                System.out.println(ex.getMessage());
                return null;
            }
    }

    public T peek() {
        if(pointer >= 0) {
            return myList.get(pointer);
        }
        return null;
    }
}
