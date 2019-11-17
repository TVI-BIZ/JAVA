package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private Provider[] providers;

    public Controller(Provider... providers) {
        if(providers != null) {
            if (providers.length == 0) {
                throw new IllegalArgumentException();
            }
        }
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
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
