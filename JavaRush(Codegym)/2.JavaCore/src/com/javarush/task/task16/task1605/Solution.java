package com.javarush.task.task16.task1605;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/* 
Поговорим о музыке
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " is starting to play");
            return new Date();
        }



        public Date stopPlaying() {
            System.out.println(this.owner + " is stopping playing");
            return new Date();
        }

        public void run (){
          long start =  startPlaying().getTime();
            sleepNSeconds(1);
          long finish = stopPlaying().getTime();

            long dateDiff = Math.abs(finish - start);
            long timediff = TimeUnit.MILLISECONDS.convert(dateDiff, TimeUnit.MILLISECONDS);
            System.out.println("Playing " + timediff + " ms");
        }
    }
}
