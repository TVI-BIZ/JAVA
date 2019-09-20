package com.javarush.task.task25.task2515;

import java.util.LinkedList;
import java.util.List;

public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private List<Ufo> ufos;
    private List<Rocket> rockets;
    private List<Bomb> bombs;


    public static void main(String[] args) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
        ufos = new LinkedList<>();
        rockets = new LinkedList<>();
        bombs = new LinkedList<>();
    }

}