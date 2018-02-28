package com.alien.java2.lesson1;

public class Dog extends Animal {
    private static String[] dogNames = {"Барбос", "Дружок", "Тузик", "Рыжик", "Мухтар"};

    private static final int RUN_MAX = 400;
    private static final int SWIM_MAX = 50;
    private static final int JUMP_MAX = 20;

    // псы бывают разные!
    private static final int RUN_MAX_DIF = 150;
    private static final int SWIM_MAX_DIF = 10;
    private static final int JUMP_MAX_DIF = 5;

    public Dog() {
        super("Пес", dogNames[rnd.nextInt(6)],
                (RUN_MAX - RUN_MAX_DIF) + rnd.nextInt(2 * RUN_MAX_DIF),
                (SWIM_MAX - SWIM_MAX_DIF) + rnd.nextInt(2 * SWIM_MAX_DIF),
                (JUMP_MAX - JUMP_MAX_DIF) + rnd.nextInt(2 * JUMP_MAX_DIF));
    }
}
