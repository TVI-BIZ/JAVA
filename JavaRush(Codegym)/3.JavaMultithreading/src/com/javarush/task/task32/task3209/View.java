package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();




    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private Controller controller;


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init(){
        initGui();
        FrameListener frameListener=new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }
    public void exit(){
        Controller controller = new Controller(this);
        controller.exit();
    }
    public void  initMenuBar(){

    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML",jScrollPane);
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст",jScrollPane1);
        tabbedPane.setPreferredSize(new Dimension(500,300));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);

    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void selectedTabChanged(){

    }

}
