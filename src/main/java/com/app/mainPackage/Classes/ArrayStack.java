package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IEnumerator;
import com.app.mainPackage.Interfaces.IStack;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * Created by alegerd on 19.02.17.
 */

public class ArrayStack<T> implements IStack<T> {

    public boolean isEmpty = true;
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public void remove() {

            }

            public boolean hasNext() {
                return (array[pointer++] != null);
            }

            public T next() {
                return array[pointer++];
            }
        };
    }

    int count = 0;

    private T array[];
    private int pointer = -1;
    private T element;

    public ArrayStack(T element){
        this.element = element;
        array = (T[])Array.newInstance(element.getClass(), 0);
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void push(T value) throws NullObjectSendedException{

        if(value == null) throw new NullObjectSendedException("Value can't be null");
        else {
            array = resize(array, array.length + 1);//scaled length for 1 element
            pointer += 1;
            count++;
            array[pointer] = value;
            isEmpty = false;
        }
    }


    public void clear() {
        array = (T[])Array.newInstance(element.getClass(),0);
        isEmpty = true;
        pointer = -1;
    }


    public T pop() throws OutOfBordersException {
            T chosenElement = null;
            if (pointer >= 0) {
                chosenElement = array[pointer];
                array = remove(array);
                pointer--;
                count--;
                return chosenElement;
            }
            else {
                throw new OutOfBordersException("Stack is empty");
            }
    }

    public T peek() throws OutOfBordersException {
        if(pointer >= 0) {
            return array[pointer];
        }
        else {
            throw new OutOfBordersException("Stack is empty");
        }
    }

    //working methods
    private T[] resize(T[] array, int newSize){
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return (T[])newArray;
    }

    private T[] remove(T[] array){
        Object[] newArray = new Object[array.length-1];
        for (int i = 0; i < array.length-1; i++) {
            newArray[i] = array[i];
        }
        return (T[])newArray;
    }
}
