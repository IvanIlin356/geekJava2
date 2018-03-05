package com.alien.java2.lesson2.enumTask;

public enum DayOfWeek {
    MONDAY("Понедельник", 5),
    TUESDAY("Вторник", 4),
    WEDNESDAY("Среда", 3),
    THURSDAY("Четверг", 2),
    FRIDAY("Пятница", 1),
    SATURDAY("Суббота", 0),
    SUNDAY("Воскресенье", 0);

    private final String rusName;
    private final int dayLeft;
    private final int wrkHours = 8;

    DayOfWeek(String rusName, int dayLeft){
        this.rusName = rusName;
        this.dayLeft = dayLeft;
    }

    public String getRusName() {
        return rusName;
    }

    public int getDayLeft() {
        return dayLeft;
    }

    public int getWrkHours() {
        return wrkHours;
    }
}
