package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enText = reader.readLine();

        SimpleDateFormat formatter = new SimpleDateFormat();
        Date resData = new Date();
        resData = new SimpleDateFormat("yyyy-MM-dd").parse(enText);

        SimpleDateFormat newDateFormat = new SimpleDateFormat("MMM dd, yyyy");


        System.out.println(newDateFormat.format(resData).toUpperCase());
    }
}
