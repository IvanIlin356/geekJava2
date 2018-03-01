package com.alien.java2.lesson1.course;

import com.alien.java2.lesson1.team.Competitor;

public class Cross extends Obstacle {
    private int distance;

    public Cross(int distance){
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(distance);
    }

    @Override
    public void obsInfo() {
        System.out.println("Кросс, длинна - " + distance);
    }
}
