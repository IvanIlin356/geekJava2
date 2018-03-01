package com.alien.java2.lesson1;

import java.util.Random;

public class Human implements Competitor {
    public static Random rnd = new Random();
    private static String[] names = {"Петр", "Василий", "Иван", "Михаил", "Сергей"};

    private static final int RUN_MAX = 300;
    private static final int SWIM_MAX = 50;
    private static final int JUMP_MAX = 15;

    private static final int RUN_MAX_DIF = 150;
    private static final int SWIM_MAX_DIF = 30;
    private static final int JUMP_MAX_DIF = 10;

    protected String name;
    int maxRun, maxSwim, maxJump;
    boolean isOnDistance;

    public Human() {
        this.name = names[rnd.nextInt(names.length)];
        this.maxRun = (RUN_MAX - RUN_MAX_DIF) + rnd.nextInt(2 * RUN_MAX_DIF);
        this.maxSwim = (SWIM_MAX - SWIM_MAX_DIF) + rnd.nextInt(2 * SWIM_MAX_DIF);
        this.maxJump = (JUMP_MAX - JUMP_MAX_DIF) + rnd.nextInt(2 * JUMP_MAX_DIF);
        this.isOnDistance = true;
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRun){
            System.out.println("    " + name + " успешно пробежал " + dist + "м. (максимум - " + maxRun + ")");
        }
        else {
            System.out.println("    " + name + " не смог пробежать " + dist + "м. (максимум - " + maxRun + ")");
            isOnDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwim){
            System.out.println("    " + name + " успешно проплыл " + dist + "м. (максимум - " + maxSwim + ")");
        }
        else {
            System.out.println("    " + name + " не смог проплыть " + dist + "м. (максимум - " + maxSwim + ")");
            isOnDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJump){
            System.out.println("    " + name + " успешно прыгнул на высоту " + height + "м. (максимум - " + maxJump + ")");
        }
        else {
            System.out.println("    " + name + " не смог перепрыгнуть " + height + "м. (максимум - " + maxJump + ")");
            isOnDistance = false;
        }
    }

    @Override
    public void info() {
        System.out.println("Участник:     " + name + ", статус - " + ((isOnDistance) ? "На дистанции" : "Выбыл") + " (параметры R/S/J: " + maxRun + "/" + maxSwim + "/" + maxJump + ")");
    }
}
