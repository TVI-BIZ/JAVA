package com.javarush.task.task40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        Calendar calendar = Calendar.getInstance();
        DateFormat formatter1 = new SimpleDateFormat("dd.MM.YYYY H:m:s");
        DateFormat formatter2 = new SimpleDateFormat("DD.M.yyyy");
        DateFormat formatter3 = new SimpleDateFormat("hh:mm:ss");

        Date ourDate = null;

        try {
            ourDate=formatter1.parse(date);
            System.out.println(ourDate);
        } catch (ParseException e) {
            try {
                ourDate=formatter2.parse(date);
                System.out.println(ourDate);
            } catch (ParseException ex) {
                try {
                    LocalTime localTime = LocalTime.parse(date, DateTimeFormatter.ofPattern("HH:mm:ss"));
                    String ampm = "";
                    if(localTime.get(ChronoField.AMPM_OF_DAY)==1){
                        ampm = "PM";
                    } else{
                        ampm="AM";
                    }
                    System.out.println("Для \""+localTime+"\":");
                    System.out.println("AM или PM: "+ampm);
                    System.out.println("Часы: "+localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
                    System.out.println("Часы дня: "+localTime.getHour());
                    System.out.println("Минуты: "+localTime.getMinute());
                    System.out.println("Секунды: "+localTime.getSecond());
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}
