package com.javarush.task.task14.task1409;

/* 
Мосты
*/

public class Solution {
    public static void main(String[] args) {

        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    //add println method here
//    public  interface Bridge{
//        int getCarsCount();
//    }
//    public static class WaterBridge implements Bridge {
//        public int getCarsCount(){
//            return 100;
//        }
//    }
//    public static class SuspensionBridge implements Bridge {
//        public int getCarsCount(){
//            return 200;
//        }
//    }

    public static void println(Bridge bridge){
        System.out.println(bridge.getCarsCount());
    }
}

