package com.alien.java2.lesson1.course;

import com.alien.java2.lesson1.team.Competitor;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height){
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }

    @Override
    public void obsInfo() {
        System.out.println("Стена, высота - " + height);
    }
}
