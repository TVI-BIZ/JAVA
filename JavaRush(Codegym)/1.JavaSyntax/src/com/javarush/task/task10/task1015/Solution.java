package com.javarush.task.task10.task1015;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);

//        ArrayList<String>[] strArrList = new ArrayList[4];
//        strArrList[0].add(0,"Str2");
//        strArrList[1].add(1,"Str3");
//        strArrList[2].add(2,"Str4");

//        ArrayList<String> arList = new ArrayList<>();
//        arList.add(0,"Str1");
//        arList.add(1,"Str2");
//        arList.add(2,"Str3");
//        arList.add(3,"Str4");
//
//        ArrayList<String> arList2 = new ArrayList<>();
//        arList2.add(0,"Str21");
//        arList2.add(1,"Str22");
//        arList2.add(2,"Str23");
//        arList2.add(3,"Str24");

//        ArrayList<String>[] finArr = new ArrayList[1];
//        finArr[0] = new ArrayList<String>();
//        finArr[0].add(0,"fffefe");

        //finArr[1].add(1,"Finel2");


    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] strArrList = new ArrayList[3];
        strArrList[0] = new ArrayList<String>();
        strArrList[1] = new ArrayList<String>();
        strArrList[2] = new ArrayList<String>();

        strArrList[0].add(0,"Str1");
        strArrList[1].add(0,"Str2");
        strArrList[2].add(0,"Str3");


        return strArrList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}