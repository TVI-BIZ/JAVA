package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Model model = new Model(view,new Provider(new HHStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();

//        String filePath = "./4.JavaCollections/src/"
//                +view.getClass().getPackage().getName().replace('.','/')+"/vacancies.html";
//        System.out.println(filePath);
    }
}
