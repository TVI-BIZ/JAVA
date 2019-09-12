package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        List<String> wordList = new LinkedList<>();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            wordList.add(line);
        }

        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        String emP = "";
        StringBuilder strBild = new StringBuilder();
        StringBuilder emptyBild = new StringBuilder(emP);
        if(words == null){
            strBild =  emptyBild;
        } else {

        }
        return strBild;
    }
}
