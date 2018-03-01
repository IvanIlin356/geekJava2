package com.alien.java2.lesson1.course;

import com.alien.java2.lesson1.team.Competitor;

public class Pool extends Obstacle {
    private int distance;

    public Pool(int distance){
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(distance);
    }

    @Override
    public void obsInfo() {
        System.out.println("Бассейн, длина - " + distance);
    }
}
