package com.alien.java2.lesson1.team;

import java.util.Random;

public class Team {
    public static final int MEMBER_COUNT = 4;
    public static Random rnd = new Random();
    public static String[] teamNames = {"Ромашка", "Занзибар", "Колесо", "эльПрофессональ", "Каучук"};

    private String teamName;
    private Competitor[] teamMembers;

    public Team(){
        this.teamName = teamNames[rnd.nextInt(teamNames.length)];
        teamMembers = new Competitor[MEMBER_COUNT];
        for (int i = 0; i < MEMBER_COUNT; i++) {
            teamMembers[i] = randomMember();
        }
    }

    private Competitor randomMember(){
        switch (rnd.nextInt(3)){
            case 0:
                return new Dog();
            case 1:
                return new Cat();
            default:
                return new Human();
        }
    }

    public void getInfo(boolean onDistance){ // true - только те, которые прошли. false - все участники
        System.out.println(" *****  ***** ");
        System.out.println("Команда " + teamName + ((onDistance) ? ", информация по членам команды прошедшим дистанцию" : ", информация по всем членам команды"));
        System.out.println(" --- --- ");
        for (Competitor teamMember : teamMembers) {
//            if (onDistance) {
//                if (teamMember.isOnDistance()) teamMember.info();
//            } else {
//                teamMember.info();
//            }
            teamMember.info();
        }
        System.out.println(" *****  ***** ");
        System.out.println();
    }

    public String getTeamName() {
        return teamName;
    }

    public Competitor[] getTeamMembers() {
        return teamMembers;
    }
}
