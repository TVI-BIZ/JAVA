package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractAction {
    public View view;
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public RedoAction(View view) {
        this.view = view;
    }


}
