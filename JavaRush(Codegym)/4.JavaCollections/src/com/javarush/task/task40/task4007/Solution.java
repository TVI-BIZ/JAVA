package com.javarush.task.task40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
        DateFormat formatter1 = new SimpleDateFormat("dd.MM.yyy H:m:s");
        DateFormat formatter2 = new SimpleDateFormat("dd.M.yyy");
        DateFormat formatter3 = new SimpleDateFormat("hh:mm:ss");

        Date ourDate = null;

        try {
            ourDate=formatter1.parse(date);
            calendar.setTime(ourDate);

           // System.out.println("Для \""+date+"\" вывод должен быть:");
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + (calendar.get(Calendar.WEEK_OF_MONTH)));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            System.out.println("AM или PM: " + calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));

        } catch (ParseException e) {
            try {
                ourDate=formatter2.parse(date);
                //System.out.println("Для \""+date+"\":");
                calendar.setTime(ourDate);
                System.out.println("День: " + calendar.get(Calendar.DATE));
                System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
                System.out.println("Год: " + calendar.get(Calendar.YEAR));

            } catch (ParseException ex) {
                try {
                    //LocalTime localTime = LocalTime.parse(date, DateTimeFormatter.ofPattern("HH:mm:ss"));
                    ourDate = formatter3.parse(date);
                    calendar.setTime(ourDate);
                    String ampm = "";
                    System.out.println("AM или PM: " + calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH));
                    System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                    System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                    System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                    System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
//                    System.out.println("AM или PM: " + ampm);
//                    System.out.println("Часы: " + calendar.get(Calendar.HOUR));
//                    System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
//                    System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
//                    System.out.println("Секунды: " + calendar.get(Calendar.SECOND));




                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}
