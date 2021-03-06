package com.alien.java2.lesson2;

import com.alien.java2.lesson2.exceptions.ArrayConvertException;
import com.alien.java2.lesson2.exceptions.ArraySizeException;

import java.util.Scanner;

public class Homework2 {
    private static Exception[] exceptions = new Exception[10];

    public static void main(String[] args) {


        boolean inProgr = true;
        Scanner scanner = new Scanner(System.in);

        // входные данные
        String[][] arr = {{"00", "01", "02", "03"},
                        {"10", "11", "12", "13"},
                        {"20", "21", "22", "23"},
                        {"30", "31", "32", "33"}};

        String[][] arr1 = {{"00", "01", "02", "03"},
                {"10", "11", "12", "13"},
                {"20", "21", "22", "23"}};

        String[][] arr2 = {{"00", "01", "02"},
                {"10", "11", "12"},
                {"20", "21", "22"},
                {"30", "31", "32"}};

        String[][] arr3 = {{"00", "01", "b2", "03"},
                {"10", "11", "12", "13"},
                {"20", "21", "22", "23"},
                {"30", "31", "32", "33"}};

        while (inProgr) {
            System.out.println("Какой массив подать на вход?");
            System.out.println("Введите 1 - правильный массив из цифр, 4х4");
            System.out.println("Введите 2 - массив 4х3");
            System.out.println("Введите 3 - массив 3х4");
            System.out.println("Введите 4 - массив с буквами");
            System.out.println("Введите 0 - завершение программы");

            switch (scanner.nextInt()){
                case 1:
                    printArray(arr);
                    System.out.println(" ----- ");
                    exceptionTest(arr);
                    break;
                case 2:
                    printArray(arr1);
                    System.out.println(" ----- ");
                    exceptionTest(arr1);
                    break;
                case 3:
                    printArray(arr2);
                    System.out.println(" ----- ");
                    exceptionTest(arr2);
                    break;
                case 4:
                    printArray(arr3);
                    System.out.println(" ----- ");
                    exceptionTest(arr3);
                    break;
                    default:
                        inProgr = false;
            }
            System.out.println(" ***** ***** ");

        }

        printExceptionsArray();
    }

    public static void tryToWorkWithArray(String [][] array) throws ArraySizeException, ArrayConvertException{
        int cellValue;
        if (array.length == 4){
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[j].length == 4) {
                        try{
                            cellValue = Integer.parseInt(array[i][j]);
                        }
                        catch (Exception e){
                            ArrayConvertException ex = new ArrayConvertException("Невозможно преобразовать значение в int", i + " x " + j, array[i][j]);
                            // Добавление в массив
                            addExceptionToArray(ex);
                            throw ex;
                        }
                        System.out.print(cellValue + "\t");
                    }
                    else {
                        ArraySizeException ex = new ArraySizeException("Размер массива может быть только 4!", array[i].length);
                        // Добавление в массив
                        addExceptionToArray(ex);
                        throw ex;
                    }
                }
                System.out.println();
            }
        }
        else{
            ArraySizeException ex = new ArraySizeException("Размер массива может быть только 4!", array.length);
            // Добавление в массив
            addExceptionToArray(ex);
            throw ex;
        }
    }

    public static void exceptionTest(String[][] array){
        try{
            tryToWorkWithArray(array);
        }
        catch (ArraySizeException e) {
            System.out.println("ИСКЛЮЧЕНИЕ! - " + e.getMessage());
            System.out.println("Текущий размер - " + e.getCurrentSize());
            e.printStackTrace();
        }
        catch (ArrayConvertException e){
            System.out.println("ИСКЛЮЧЕНИЕ! - " + e.getMessage());
            System.out.println("Ячейка - " + e.getCellCoord() + ", Значение - " + e.getCellValue());
            e.printStackTrace();
        }
    }

    public static void printArray(String[][] array){
        System.out.println(" ***** ***** ");
        System.out.println("Исходный массив: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // exception array

    private static int getLastExceptionArrayNum(){
        for (int i = 0; i < exceptions.length; i++) {
            if (exceptions[i] == null)
                return i;
        }
        return -1;
    }

    private static void  addExceptionToArray(Exception ex){
        int lastID = getLastExceptionArrayNum();
        if (lastID != -1){
            exceptions[lastID] = ex;
        }
        else {
            System.out.println("Массив эксепшенов переполнен!");
        }

    }

    private static void printExceptionsArray(){
        System.out.println("Полученный массив Ексепшенов");
        for (int i = 0; i < exceptions.length; i++) {
            if (exceptions[i] != null){
                System.out.println((i + 1) + ") " + exceptions[i].getClass() + " " + exceptions[i].getMessage());
            }
        }
    }
}
