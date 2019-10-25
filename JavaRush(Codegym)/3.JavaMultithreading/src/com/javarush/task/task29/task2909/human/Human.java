package com.javarush.task.task29.task2909.human;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    //protected int[] size;
    public class Size{
        public int height;
        public int weight;
    }


    protected Size size;



//    public static final int FIRST = 1;
//    public static final int SECOND = 2;
//    public static final int THIRD = 3;
//    public static final int FOURTH = 4;
//    private int bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    private BloodGroup bloodGroup;





//    public void setBloodGroup(int code) {
//        bloodGroup = code;
//    }




    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }


    private List<Human> children = new ArrayList<>();


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }




    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public void removeChild(Human human) {
        children.remove(human);
    }

    @Override
    public void live() {

    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

}