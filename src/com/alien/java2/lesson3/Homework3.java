package com.alien.java2.lesson3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Homework3 {
    private static String[] wordsTemplate = {"Кот", "Пес", "Рыба", "Птица", "Грызун", "Насекомое", "Рептилия"};
    private static Random rnd = new Random();

    public static void main(String[] args) {

        task1();

    }

    private static void task1() {
        String[] words = new String[20];
        for (int i = 0; i < words.length; i++) {
            words[i] = wordsTemplate[rnd.nextInt(wordsTemplate.length)];
        }


        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            hashMap.put(words[i], hashMap.getOrDefault(words[i], 0) + 1);
        }

        System.out.println(hashMap.toString());
    }
}
