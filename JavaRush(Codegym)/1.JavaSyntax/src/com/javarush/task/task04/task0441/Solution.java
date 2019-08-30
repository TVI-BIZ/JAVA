package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int c1 = Integer.parseInt(reader.readLine());
        int c2 = Integer.parseInt(reader.readLine());
        int c3 = Integer.parseInt(reader.readLine());
        int midInt;

        if (c1 == c2 && c1 == c3 && c2==c3){
            System.out.println(c2);
        } else if (c1 == c2) {
            System.out.println(c1);
        } else if (c2 == c3) {
            System.out.println(c2);
        } else if (c1 == c3){
            System.out.println(c1);
        } else {
            if((c1 > c2 && c1 < c3)||((c1 < c2 && c1 > c3))){
                midInt = c1;
                System.out.println(midInt);
            } else if ((c2 > c3 && c2 < c1)||(c2<c3 && c2 > c1)){
                midInt = c2;
                System.out.println(midInt);
            } else if ((c3 > c1 && c3 < c2)||(c3<c1 && (c3>c2))){
                midInt = c3;
                System.out.println(midInt);
            }

        }








    }
}
