package com.app.mainPackage.Exceptions;

/**
 * Created by alegerd on 3/2/17.
 */
public class OutOfBordersException extends StackException {

    public OutOfBordersException() {}

    public OutOfBordersException(String message){
        super(message);
    }
}
