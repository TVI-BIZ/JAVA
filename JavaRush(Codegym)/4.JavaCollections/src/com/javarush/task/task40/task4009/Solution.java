package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
        //System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("d.M.yyyy",Locale.ITALIAN);
        LocalDate localDate = null;
        localDate = LocalDate.parse(birthday, dateTimeFormatter1);
        LocalDate finDate = null;
        Year finYear = Year.parse(year);
        finDate = localDate.withYear(Integer.parseInt(year));
        LocalDate localDate3=localDate;

        //Day of week in Italian
        String dateInItaly=finDate.format(DateTimeFormatter.ofPattern("EEEE",Locale.ITALIAN));
        return dateInItaly;
    }
}
