package com.javarush.task.task25.task2502;

import java.lang.reflect.Array;
import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            Wheel[] wheelsArray = Wheel.values();
            if(loadWheelNamesFromDB().length == 0){
                throw new Exception();
            }
            if(loadWheelNamesFromDB().length != Wheel.values().length){
                throw new IllegalArgumentException();
            }
            List<Wheel> whelList = new ArrayList();
            for(String elem:loadWheelNamesFromDB()){
                whelList.add(Wheel.valueOf(elem));
            }

//            for(Wheel elem:whelList){
//                wheels.add(elem);
//            }
            wheels = whelList;

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {

    }
}
