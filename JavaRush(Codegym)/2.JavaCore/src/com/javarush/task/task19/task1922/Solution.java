package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file1);
        String sumStr = "";

        while (fileReader.ready()){
            int data = fileReader.read();
            sumStr += (char)data;
        }
        String[] strArr = sumStr.split("\n");

        for(String elem: strArr){
            String[] elemArr = elem.split(" ");
            int flag = 0;
            for(String elem2: words){
                for(String elem3: elemArr){
                    if (elem2.equals(elem3)){
                        flag++;
                    }
                }
            }
            if(flag == 2){
                System.out.println(elem);
            }
        }
        fileReader.close();
    }
}
