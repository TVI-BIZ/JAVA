package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.util.concurrent.ConcurrentSkipListSet;

public class Controller {
    private static View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        view = new View();

        //View viewMain = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }
    public void init(){

    }
    public void exit(){
        System.exit(0);
    }

}
