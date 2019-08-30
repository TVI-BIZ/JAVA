package com.javarush.task.task14.task1403;

/* 
Building и School
*/

import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        School school = new School();
        return school;
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        Building building = new Building();
        return building;
    }

    static class School /*Добавьте сюда ваш код*/ extends Building  {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building /*Добавьте сюда ваш код*/  {
        @Override
        public String toString() {
            return "Building";
        }
    }
}
