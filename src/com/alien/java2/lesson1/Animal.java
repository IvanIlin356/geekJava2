package com.alien.java2.lesson1;

import java.util.Random;

public class Animal implements Competitor {
    public static Random rnd = new Random();

    protected String type;
    protected String name;

    int maxRun, maxSwim, maxJump;

    boolean isOnDistance;

    public Animal(String type, String name, int maxRun, int maxSwim, int maxJump){
        this.type = type;
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
        this.isOnDistance = true;
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRun){
            System.out.println(type + " " + name + " успешно пробежал " + dist + "м. (максимум - " + maxRun + ")");
        }
        else {
            System.out.println(type + " " + name + " не смог пробежать " + dist + "м. (максимум - " + maxRun + ")");
            isOnDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwim){
            System.out.println(type + " " + name + " успешно проплыл " + dist + "м. (максимум - " + maxSwim + ")");
        }
        else {
            System.out.println(type + " " + name + " не смог проплыть " + dist + "м. (максимум - " + maxSwim + ")");
            isOnDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJump){
            System.out.println(type + " " + name + " успешно перепрыгнул высоту " + height + "м. (максимум - " + maxJump + ")");
        }
        else {
            System.out.println(type + " " + name + " не смог перепрыгнуть " + height + "м. (максимум - " + maxJump + ")");
            isOnDistance = false;
        }
    }

    @Override
    public void info() {
        System.out.println("Участник: " + type + " " + name + ", статус - " + ((isOnDistance) ? "На дистанции" : "Выбыл") + " (параметры R/S/J: " + maxRun + "/" + maxSwim + "/" + maxJump + ")");
    }
}
