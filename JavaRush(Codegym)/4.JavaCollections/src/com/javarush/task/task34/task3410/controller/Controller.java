package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Model;
import com.javarush.task.task34.task3410.view.View;

public class Controller {
    private View view;
    private Model model;


    public Controller() {
        this.view = new View(null);
        this.model = new Model();
    }

//    public Controller(View view, Model model) {
//        this.view = view;
//        this.model = model;
//    }

    public static void main(String[] args) {

    }
}
