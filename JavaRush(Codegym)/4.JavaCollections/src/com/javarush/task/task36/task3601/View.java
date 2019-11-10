package com.javarush.task.task36.task3601;

import java.util.List;

public class View {
    Controller controller = new Controller();

    //Model model = new Model();

    public void fireShowDataEvent() {

        System.out.println(controller.onShowDataList());
    }
}
