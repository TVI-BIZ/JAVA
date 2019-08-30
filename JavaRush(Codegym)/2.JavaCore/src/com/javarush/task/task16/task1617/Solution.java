package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут

//        if(numSeconds > 3.5){
           // Thread.sleep(3500);
//            //clock.interrupt();
//            clock.interrupt();
//            System.out.println("4 3 2 1 Прервано!");
//        }
//        while(!clock.isInterrupted()) {
//            Thread.sleep(1000);
//            if (numSeconds > 0) {
//                System.out.print(numSeconds + " ");
//                numSeconds--;
//            } else {
//                System.out.print("Марш!");
//                //Thread.sleep(3500);
//                clock.interrupt();
//            }
//        }
        Thread.sleep(3500);

        clock.interrupt();




    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {



            //add your code here - добавь код тут
//            if(numSeconds > 3.5){
                try{
                    while(!this.isInterrupted()){
                        if(numSeconds > 0){
                            System.out.print(numSeconds + " ");
                            numSeconds --;
                            Thread.sleep(1000);
                        } else {
                            System.out.print("Марш!");
                            //Thread.sleep(3500);
                            this.interrupt();
                        }
                    }
                } catch (InterruptedException e){
                    System.out.println("Прервано!");
                    //System.out.println(e);
                }
//            } else {
//                try{
//                    while(!this.isInterrupted()){
//                        Thread.sleep(1000);
//                        if(numSeconds > 0){
//                            System.out.print(numSeconds + " ");
//                            numSeconds --;
//                        } else {
//                            System.out.print("Марш!");
//                            //Thread.sleep(3500);
//                            this.interrupt();
//                        }
//
//                    }
//                } catch (InterruptedException e){
//                    System.out.println(e);
//                }
//
//            }



        }
    }
}
