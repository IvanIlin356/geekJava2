package com.alien.java2.lesson1.team;

public class Cat extends Animal {
    private static String[] catNames = {"Барсик", "Мурзик", "Серый", "Опёнок", "Шрёдингер"};

    public static final int RUN_MAX = 200;
    public static final int SWIM_MAX = 20;
    public static final int JUMP_MAX = 50;

    // коты бывают разные!
    private static final int RUN_MAX_DIF = 150;
    private static final int SWIM_MAX_DIF = 10;
    private static final int JUMP_MAX_DIF = 25;

    public Cat() {
        super("Кот", catNames[rnd.nextInt(catNames.length)],
                (RUN_MAX - RUN_MAX_DIF) + rnd.nextInt(2 * RUN_MAX_DIF),
                (SWIM_MAX - SWIM_MAX_DIF) + rnd.nextInt(2 * SWIM_MAX_DIF),
                (JUMP_MAX - JUMP_MAX_DIF) + rnd.nextInt(2 * JUMP_MAX_DIF));
    }
}
