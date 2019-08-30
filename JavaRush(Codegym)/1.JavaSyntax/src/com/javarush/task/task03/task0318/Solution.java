package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1  = reader.readLine();
        String name = reader.readLine();
        //String s1  = reader.readLine();
        //int nAge = Integer.parseInt(s1);

        System.out.println(name +  " захватит мир через " + s1 + " лет. Му-ха-ха!");

    }
}
