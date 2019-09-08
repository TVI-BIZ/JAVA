package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List horses){
        this.horses = horses;
    }

    public static Hippodrome game;
    public static void main(String[] args) throws InterruptedException {

        Horse horse1 = new Horse("Belka",3.0,0.0);
        Horse horse2 = new Horse("Strelka",3.0,0.0);
        Horse horse3 = new Horse("Reks",3.0,0.0);

        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        game.run();

        game.printWinner();
    }

    public void run() throws InterruptedException {
        for(int i = 1; i < 101; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }
    public void move(){
        for(Horse elem: horses){
            elem.move();
        }

    }
    public void print(){
        for(Horse elem: horses){
            elem.print();
        }
        for(int i=0; i < 10; i++){
            System.out.println();
        }
    }
    public Horse getWinner(){
        double max = 0;
        Horse winner = new Horse("",0.0,0.0);
        for (Horse elem: horses){
           if(elem.getDistance() > max){
               max = elem.getDistance();
               winner = elem;
           }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


}
