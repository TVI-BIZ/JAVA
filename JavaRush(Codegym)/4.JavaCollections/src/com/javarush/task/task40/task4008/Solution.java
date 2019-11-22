package com.javarush.task.task40.task4008;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
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
        //Calendar calendar = Calendar.getInstance();
        DateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy H:m:s");
        DateFormat formatter2 = new SimpleDateFormat("dd.M.yyyy");
        DateFormat formatter3 = new SimpleDateFormat("hh:mm:ss");

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("d.M.yyyy H:m:s");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("d.M.yyyy");
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("H:m:s");


        Date ourDate = null;
        LocalDate localDate = null;
        LocalTime localTime = null;


        try {
            localDate = LocalDate.parse(date, dateTimeFormatter1);
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonthValue());
            System.out.println("Год: " + localDate.getYear());

            String[] divData = date.split(" ");

            localTime = LocalTime.parse(divData[1],dateTimeFormatter3);
            System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());


        } catch (Exception e) {
            try {
                localDate = LocalDate.parse(date, dateTimeFormatter2);
                System.out.println("День: " + localDate.getDayOfMonth());
                System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
                System.out.println("День месяца: " + localDate.getDayOfMonth());
                System.out.println("День года: " + localDate.getDayOfYear());
                System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
                System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
                System.out.println("Месяц: " + localDate.get(ChronoField.MONTH_OF_YEAR));
                System.out.println("Год: " + localDate.getYear());



            } catch (Exception ex) {
                try {
                    localTime = LocalTime.parse(date, dateTimeFormatter3);
                    System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
                    System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
                    System.out.println("Часы дня: " + localTime.getHour());
                    System.out.println("Минуты: " + localTime.get(ChronoField.MINUTE_OF_HOUR));
                    System.out.println("Секунды: " + localTime.get(ChronoField.SECOND_OF_MINUTE));


                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }


        //localTime = LocalTime.parse(date, dateTimeFormatter3);

    }
}
