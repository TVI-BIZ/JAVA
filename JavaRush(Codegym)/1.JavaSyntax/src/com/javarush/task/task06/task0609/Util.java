package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        double res = Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)) );
        return res;

    }

    public static void main(String[] args) {
        //System.out.println(getDistance(6,5,4,3));
    }
}
