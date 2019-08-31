package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader reader1 = new FileReader(args[0]);
        FileWriter writer2 = new FileWriter(args[1]);

//        FileReader reader1 = new FileReader("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");
//        FileWriter writer2 = new FileWriter("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f2.txt");

        String sumString = "";

        while (reader1.ready()){
            int data = reader1.read();
            sumString += (char)data;
        }
        reader1.close();
        String[] stringArr = sumString.split("\n");

        for(String elem:stringArr){
            String[] strTemp = elem.split(" ");
                for (String elem2: strTemp){
                    if (elem2.matches(".*\\d.*")){
                        writer2.write(elem2 + " ");
                    }
                }
        }
        writer2.close();
    }
}
