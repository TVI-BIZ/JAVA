package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private final static String URL_FORMAT =
            "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    public String myTest = String.format(URL_FORMAT,"Kiev", 3);


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        return null;
    }
}
