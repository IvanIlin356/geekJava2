package com.alien.java2.lesson2.exceptions;

public class ArrayConvertException extends Exception {
    private String cellCoord;
    private String cellValue;

    public ArrayConvertException (String msg, String cellCoord, String cellValue){
        super(msg);
        this.cellCoord = cellCoord;
        this.cellValue = cellValue;
    }

    public String getCellCoord() {
        return cellCoord;
    }

    public String getCellValue() {
        return cellValue;
    }
}
