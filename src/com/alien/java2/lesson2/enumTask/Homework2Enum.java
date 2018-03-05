package com.alien.java2.lesson2.enumTask;

public class Homework2Enum {

    public static void main(String[] args) {
        System.out.println("Проверим остаток рабочих часов");
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println("День " + day.getRusName());
            System.out.println("Остаток часов " + getWotrkHours(day));
            System.out.println("***");
        }

    }

    public static int getWotrkHours(DayOfWeek day){
        if(day.getDayLeft() != 0){
            return (day.getDayLeft() * day.getWrkHours());
        } else {
            return 0;
        }
    }
}
