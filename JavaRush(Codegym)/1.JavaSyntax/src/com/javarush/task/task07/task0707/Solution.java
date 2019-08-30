package com.javarush.task.task07.task0707;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        list.add("Hi");
        list.add("Hi1");
        list.add("Hi2");
        list.add("Hi3");
        list.add("Hi4");

        System.out.println(list.size());

        for(int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i));
        }


    }
}
