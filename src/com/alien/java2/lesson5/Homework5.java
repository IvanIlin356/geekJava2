package com.alien.java2.lesson5;

public class Homework5 {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;
    private static float[] array;
    private static float[] halfArray1;
    private static float[] halfArray2;
    private static long prevTime;

    public static void main(String[] args) {
        array = new float[SIZE];
        halfArray1 = new float[HALF_SIZE];
        halfArray2 = new float[HALF_SIZE];

        calculateWithoutThread();
        calculateWithThread();
    }

    private static void fillArrayWith1(){
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
    }

    private static void calculateWithoutThread(){
        fillArrayWith1();
        prevTime = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время работы первого метода: " + (System.currentTimeMillis() - prevTime));
    }

    private static void calculateWithThread(){
        fillArrayWith1();

        prevTime = System.currentTimeMillis();

        System.arraycopy(array, 0, halfArray1, 0, HALF_SIZE);
        System.arraycopy(array, HALF_SIZE, halfArray2, 0, HALF_SIZE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < halfArray1.length; i++) {
                    halfArray1[i] = (float)(halfArray1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < halfArray2.length; i++) {
                halfArray2[i] = (float)(halfArray1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        System.arraycopy(halfArray1, 0, array, 0, HALF_SIZE);
        System.arraycopy(halfArray2, 0, array, HALF_SIZE, HALF_SIZE);

        System.out.println("Время работы второго метода: " + (System.currentTimeMillis() - prevTime));
    }
}
