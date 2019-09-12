package com.javarush.task.task22.task2210;



import java.util.LinkedList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
       LinkedList<String> listStr = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            listStr.add(token);
        }


        String[] resArr = new String[listStr.size()];
        for(int i=0; i < resArr.length; i ++){
            resArr[i] = listStr.get(i);
        }

        return resArr;
    }
}
