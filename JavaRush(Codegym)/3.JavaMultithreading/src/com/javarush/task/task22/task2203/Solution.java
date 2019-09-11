package com.javarush.task.task22.task2203;

import java.util.LinkedList;
import java.util.List;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string ==null) {
            throw new TooShortStringException();
        }
        int tabCount = string.length() - string.replaceAll("\t","").length();
        int counter = 0;
        String resString = null;
        List<Integer> tabPositions = new LinkedList<>();
        if(tabCount >= 2){
            for(int i = 0; i < string.length();i++){
                if(string.charAt(i) == '\t'){
                    tabPositions.add(counter);
                }
                counter++;
            }
            if(tabPositions.size() >= 2){
                resString = string.substring(tabPositions.get(0)+1,tabPositions.get(1));
            } else {
                resString = string.substring(tabPositions.get(0)+1);
            }
        } else {
            throw  new TooShortStringException();
        }
        return resString;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
