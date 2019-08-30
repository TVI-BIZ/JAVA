package com.javarush.task.task08.task0827;

import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JAN 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        boolean res = false;
            try{
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
//                LocalDate localD = LocalDate.parse(date,formatter);
//                System.out.println(localD);
                Calendar c = Calendar.getInstance();


                Date date1=new SimpleDateFormat("MMM d yyyy").parse(date);
                //System.out.println(date+"\t"+date1);

                c.setTime(date1);

                int days = c.get(Calendar.DATE);
                int months = c.get(Calendar.MONTH);
                int years = c.get(Calendar.YEAR);
                String yearStart  = "JAN 1 ";
                //System.out.println(yearStart+years);

                Date date3 = new SimpleDateFormat("MMM d yyyy").parse(yearStart+years);

                long diff = date3.getTime() - date1.getTime();
                float daysFin = (diff / (1000*60*60*24));


               // System.out.println(daysFin);
                //boolean res = false;
                if ( daysFin % 2 == 0){
                    res = true;
                } else {
                    res = false;
                }
                //System.out.println(date3);
                //System.out.println(date1.getYear());



            } catch (Exception e){
                System.out.println(e);
            }




        return res;
    }
}
