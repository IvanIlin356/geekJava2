package com.alien.java2.lesson1;

import com.alien.java2.lesson1.course.Course;
import com.alien.java2.lesson1.team.Team;

public class Homework1 {

    public static void main(String[] args) {
        Team team = new Team();
        team.getInfo(false);

        Course course = new Course();
        course.courseInfo();
        course.doIt(team);

        team.getInfo(true);

    }
}
