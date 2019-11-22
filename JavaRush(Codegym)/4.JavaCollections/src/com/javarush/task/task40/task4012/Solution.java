package com.javarush.task.task40.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isLeap(LocalDate date) {
        if (date.isLeapYear()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        if (dateTime.isBefore(dateTime)) {
            return true;
        } else {
            return false;
        }
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);

    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate)) {
            return Period.between(firstDate, secondDate);
        } else {
            return Period.between(secondDate, firstDate);
        }
    }
}
