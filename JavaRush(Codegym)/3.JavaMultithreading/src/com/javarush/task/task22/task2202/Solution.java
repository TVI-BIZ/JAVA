package com.javarush.task.task22.task2202;

import java.util.LinkedList;
import java.util.List;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string ==null) {
            throw new TooShortStringException();
        }

        int spaceCount = string.length() - string.replaceAll(" ","").length();
        int counter = 0;
        String resString = null;
        List<Integer> spacePositions = new LinkedList<>();




        if(spaceCount >= 4){
            for(int i = 0; i < string.length();i++){
                if(string.charAt(i) == ' '){
                    spacePositions.add(counter);
                }
                counter++;
            }

            if(spacePositions.size() > 4){
                resString = string.substring(spacePositions.get(0)+1,spacePositions.get(4));
            } else {
                resString = string.substring(spacePositions.get(0)+1);
            }

        } else {
            throw new TooShortStringException();
        }

        return resString;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
