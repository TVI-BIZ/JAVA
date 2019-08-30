package com.javarush.task.task13.task1325;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Компиляция программы
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BigFox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());

    }

    public interface Animal {
        Color getColor();
    }

    public abstract static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
//        public Color getColor(){
//            return Color.BLACK;
//        }

    }

    public  static class BigFox extends Fox{
                public Color getColor(){
            return Color.BLACK;
        }
    }



}
