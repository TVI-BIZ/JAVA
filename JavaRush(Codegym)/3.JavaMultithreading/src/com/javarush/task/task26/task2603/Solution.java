package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }
    public static class CustomizedComparator<T> {
        public CustomizedComparator(Comparator<T>[] comparators) {
            this.comparators = comparators;
        }

        private Comparator<T>[] comparators;


    }
}
