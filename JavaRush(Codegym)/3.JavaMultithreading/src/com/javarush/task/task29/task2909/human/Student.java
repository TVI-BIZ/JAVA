package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;

    public void setCourse(int value) {
        this.course = value;
    }

    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name,age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta){
        //averageGrade += delta;

        double ag = getAverageGrade();
        ag +=delta;
        setAverageGrade(ag);
    }





    public void setBeginningOfSession(Date date){
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date){
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }
}