package com.alien.java2.lesson1.course;

import com.alien.java2.lesson1.team.*;

import java.util.Random;

public class Course{
    private static Random rnd = new Random();
    private static final int OBS_COUNT = 4;
    private Obstacle[] obstacles;

    public Course(){
        obstacles = new Obstacle[OBS_COUNT];
        for (int i = 0; i < OBS_COUNT; i++) {
            obstacles[i] = randomObs();
        }
    }

    private Obstacle randomObs(){
        switch (rnd.nextInt(3)){
            case 0:
                return new Wall(rnd.nextInt(Dog.JUMP_MAX) + 1);
            case 1:
                return new Cross(rnd.nextInt(Human.RUN_MAX) + 1);
            default:
                return new Pool(rnd.nextInt(Cat.SWIM_MAX) + 1);
        }
    }

    public void doIt(Team team){
        System.out.println(" * Команда " + team.getTeamName() + " приступила к полосе препятствий!");
        System.out.println();

        for (Competitor member : team.getTeamMembers()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(member);
                if (!member.isOnDistance()) break;
            }
            System.out.println(" - ");
        }
        System.out.println();
        System.out.println(" * Прохождение полосы препятствий завершено");
        System.out.println();

    }

    public void courseInfo(){
        System.out.println(" +++++ ");
                System.out.println("Информация по полосе препятствий:");
        for (Obstacle obstacle : obstacles) {
            obstacle.obsInfo();
        }
        System.out.println(" +++++ ");
        System.out.println();
    }
}
