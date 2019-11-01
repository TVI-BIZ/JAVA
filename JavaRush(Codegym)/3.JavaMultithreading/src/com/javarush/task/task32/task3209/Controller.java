package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;


import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Controller {
    private View view;

    public HTMLDocument getDocument() {
        return document;
    }

    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();

        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }
    public void init(){
        createNewDocument();
    }
    public void exit(){

        System.exit(0);
    }

    public void resetDocument(){
        if(document != null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit kit = new HTMLEditorKit();
        document = (HTMLDocument) kit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text) {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try{
            HTMLEditorKit kit = new HTMLEditorKit();
            kit.read(stringReader,document,0);
            stringReader.read();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        String res = "";
        try{
            HTMLEditorKit kit = new HTMLEditorKit();
            kit.write(stringWriter,document,0,document.getLength());

        }catch (Exception e){
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }
    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }
    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //jFileChooser.showOpenDialog(view);
        //jFileChooser.showOpenDialog(view);


        if(jFileChooser.showOpenDialog(view)==JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            try {
                FileReader fileReader = new FileReader(currentFile);
                HTMLEditorKit kit  = new HTMLEditorKit();
                kit.read(fileReader,document,0);
                view.resetUndo();
            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }

    }
    public void saveDocument(){
        view.selectHtmlTab();
         if(currentFile != null) {
             view.setTitle(currentFile.getName());
             try {
                 FileWriter fileWriter = new FileWriter(currentFile);
                 HTMLEditorKit kit = new HTMLEditorKit();
                 kit.write(fileWriter, document, 0, document.getLength());
             } catch (Exception e) {
                 ExceptionHandler.log(e);
             }

         } else {
             saveDocumentAs();
         }
    }

    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //jFileChooser.showSaveDialog(view);

        if(jFileChooser.showSaveDialog(view)==JFileChooser.APPROVE_OPTION){
            //jFileChooser.accept(currentFile);
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());

            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                HTMLEditorKit kit  = new HTMLEditorKit();
                kit.write(fileWriter,document,0,document.getLength());
            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }



}
