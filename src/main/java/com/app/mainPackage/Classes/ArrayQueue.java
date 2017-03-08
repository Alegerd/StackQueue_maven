package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IEnumerator;
import com.app.mainPackage.Interfaces.IQueue;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * Created by alegerd on 19.02.17.
 */
public class ArrayQueue<T> implements IQueue<T> {

    public int count;
    public boolean isEmpty = true;

    private T array[];
    private T element;

    public ArrayQueue(T element) {
        this.element = element;
        array = (T[]) Array.newInstance(element.getClass(), 0);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return (array[0] != null);
            }

            public T next() {
                try {
                    return dequeue();
                }
                catch (OutOfBordersException e)
                {
                    System.out.println(e.getMessage());
                }
                finally {
                    return null;
                }
            }

            public void remove() {

            }
        };
    }

    public void enqueue(T value) throws NullObjectSendedException{
        if(value != null) {
            array = resize(array, array.length + 1);
            array[array.length - 1] = value;
            count++;
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
        array = (T[]) Array.newInstance(element.getClass(), 0);
        isEmpty = true;
    }

    public T dequeue() throws OutOfBordersException{
        if (count == 0) {
            isEmpty = true;
            throw new OutOfBordersException("Queue is empty");
        }
        else {
            T chosenElement = array[0];
            array = remove(array);
            count--;

            return chosenElement;
        }
    }

    public T peek() throws OutOfBordersException {
        T choosenElement = array[0];
        if (choosenElement == null) {
            throw new OutOfBordersException("Queue is empty");
        }
        return choosenElement;
    }

    //working methods
    private T[] resize(T[] array, int newSize) {
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return (T[]) newArray;
    }

    private T[] remove(T[] array) {
        Object[] newArray = new Object[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            newArray[i] = array[i + 1];
        }
        return (T[]) newArray;
    }
}
