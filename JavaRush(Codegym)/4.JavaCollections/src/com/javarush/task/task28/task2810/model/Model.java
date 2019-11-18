package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        this.view = view;
        this.providers = providers;

        if(providers==null||view==null||providers.length==0){
            throw new IllegalArgumentException();
        }

    }
    public void selectCity(String city){
        List<Vacancy> vacancyList = new ArrayList<>();
        for(Provider elem:providers){
           for(Vacancy elem2: elem.getJavaVacancies(city)){
               vacancyList.add(elem2);
           }
        }
        view.update(vacancyList);
    }

    public void scan() {
        List<Vacancy> vacancyList = new ArrayList<>();
        for(Provider elem:providers){
            List<Vacancy> tempList =  elem.getJavaVacancies(null);
            for (Vacancy elem2:tempList){
                vacancyList.add(elem2);
            }
        }
        System.out.println(vacancyList.size());
    }
}
