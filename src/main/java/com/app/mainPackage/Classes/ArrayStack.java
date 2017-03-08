package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IEnumerator;
import com.app.mainPackage.Interfaces.IStack;

import java.lang.reflect.Array;

/**
 * Created by alegerd on 19.02.17.
 */

public class ArrayStack<T> implements IStack<T> {


    private T array[];
    private int pointer = -1;
    private T element;

    int count = 0;
    public boolean isEmpty = true;

/*    public void setArray(T[] value){
        this.array = array;
    }

    public T[] getArray(){
        return array;
    }*/

    public ArrayStack(T element){
        this.element = element;
        array = (T[])Array.newInstance(element.getClass(), 0);
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
        array = resize(array,array.length + 1);//scaled length for 1 element
        pointer+=1;
        count++;
        array[pointer] = value;
        isEmpty = false;
    }


    public void clear() {
        array = (T[])Array.newInstance(element.getClass(),0);
        isEmpty = true;
        pointer = -1;
    }


    public T pop() {
        try {
            T chosenElement = null;
            if (pointer >= 0) {
                chosenElement = array[pointer];
                array = remove(array);
                pointer--;
                count--;
                return chosenElement;
            }
            else {
                isEmpty = true;
                throw new OutOfBordersException("the list is empty");
            }
        }
        catch (OutOfBordersException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public T peek() {
        if(pointer >= 0) {
            return array[pointer];
        }
        return null;
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
