package com.alien.java2.lesson2.exceptions;

public class ArraySizeException extends Exception {
    private int currentSize;

    public ArraySizeException(String msg, int curSize){
        super(msg);
        this.currentSize = curSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
