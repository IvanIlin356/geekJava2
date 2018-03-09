package com.alien.java2.lesson3;

import java.util.*;

public class Homework3 {
    private static String[] wordsTemplate = {"Кот", "Пес", "Рыба", "Птица", "Грызун", "Насекомое", "Рептилия"};
    private static Random rnd = new Random();

    public static void main(String[] args) {

        //task1();
        //task2();
        extraTask3();

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
        System.out.println("Уникальные слова и количество повторений:");
        System.out.println(hashMap.toString());
    }

    private static void task2(){
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Петя", 345544);
        phoneBook.addContact("Маша", 343234);
        phoneBook.addContact("Дима", 544655);
        phoneBook.addContact("Петя", 865567);

        phoneBook.getContact("Петя");
    }

    private static void extraTask3(){
        final int cycleCount = 10;
        long lastTime, runTime;
        long delta = 0, cycleDelta;

        // ***** linkedList
        System.out.println("LinkedList Test");
        LinkedList<String> linkedList = new LinkedList<String>();

        System.out.print("add:");
        cycleDelta = 0;
        for (int i = 0; i < cycleCount; i++) {
            lastTime = System.nanoTime();
            linkedList.add("testString");
            cycleDelta += System.nanoTime() - lastTime;
        }
        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");

        System.out.print("get:");
        cycleDelta = 0;
        for (int i = 0; i < cycleCount; i++) {
            lastTime = System.nanoTime();
            linkedList.get(i);
            cycleDelta += System.nanoTime() - lastTime;
        }
        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");

        System.out.print("remove:");
        cycleDelta = 0;
        for (int i = 0; i < cycleCount; i++) {

            lastTime = System.nanoTime();
            linkedList.removeLast();
            cycleDelta += System.nanoTime() - lastTime;
        }

        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");


        System.out.println();
        // ***** arrayList
        System.out.println("ArrayList Test");
        ArrayList<String> arrayList = new ArrayList<>();

        System.out.print("add:");
        cycleDelta = 0;
        for (int i = 0; i < cycleCount; i++) {
            lastTime = System.nanoTime();
            arrayList.add("testString");
            cycleDelta += System.nanoTime() - lastTime;
        }
        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");

        System.out.print("get:");
        cycleDelta = 0;
        for (int i = 0; i < cycleCount; i++) {
            lastTime = System.nanoTime();
            arrayList.get(i);
            cycleDelta += System.nanoTime() - lastTime;
        }
        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");

        System.out.print("remove:");
        cycleDelta = 0;
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            iterator.next();
            lastTime = System.nanoTime();
            iterator.remove();
            cycleDelta += System.nanoTime() - lastTime;
        }

        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");


        System.out.println();
        // ***** treeSet
        System.out.println("TreeSet Test");
        TreeSet<String> treeSet = new TreeSet<String>();

        System.out.print("add:");
        cycleDelta = 0;
        for (int i = 0; i < cycleCount; i++) {
            lastTime = System.nanoTime();
            treeSet.add("testString");
            cycleDelta += System.nanoTime() - lastTime;
        }
        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");

        System.out.print("get:");
        cycleDelta = 0;
        Iterator<String> treeIterator = treeSet.iterator();
        while (treeIterator.hasNext()){
            //treeIterator.next();
            lastTime = System.nanoTime();
            treeIterator.next();
            cycleDelta += System.nanoTime() - lastTime;
        }
        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");

        System.out.print("remove:");
        cycleDelta = 0;

        Iterator<String> treeIterator2 = treeSet.iterator();
        while (treeIterator2.hasNext()){
            treeIterator2.next();
            lastTime = System.nanoTime();
            treeIterator2.remove();
            cycleDelta += System.nanoTime() - lastTime;
        }

        delta = cycleDelta / cycleCount;
        System.out.println("avg time = " + delta + " nanosec");

    }
}
