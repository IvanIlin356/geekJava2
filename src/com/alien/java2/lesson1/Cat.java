package com.alien.java2.lesson1;

public class Cat extends Animal {
    private static String[] catNames = {"Барсик", "Мурзик", "Серый", "Опёнок", "Шрёдингер"};

    private static final int RUN_MAX = 200;
    private static final int SWIM_MAX = 10;
    private static final int JUMP_MAX = 50;

    // коты бывают разные!
    private static final int RUN_MAX_DIF = 150;
    private static final int SWIM_MAX_DIF = 9;
    private static final int JUMP_MAX_DIF = 25;

    public Cat(String name, int maxRun, int maxSwim, int maxJump) {
        super("Кот", catNames[rnd.nextInt(6)],
                (RUN_MAX - RUN_MAX_DIF) + rnd.nextInt(2 * RUN_MAX_DIF),
                (SWIM_MAX - SWIM_MAX_DIF) + rnd.nextInt(2 * SWIM_MAX_DIF),
                (JUMP_MAX - JUMP_MAX_DIF) + rnd.nextInt(2 * JUMP_MAX_DIF));
    }
}
