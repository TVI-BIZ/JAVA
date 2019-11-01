package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();

    public UndoListener getUndoListener() {
        return undoListener;
    }

    private UndoListener undoListener = new UndoListener(undoManager);







    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private Controller controller;


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String newEvent = actionEvent.getActionCommand();
        if(newEvent.equals("Новый")){
            controller.createNewDocument();
        } else if (newEvent.equals("Открыть")){
            controller.openDocument();
        } else if(newEvent.equals("Сохранить")){
            controller.saveDocument();
        } else if(newEvent.equals("Сохранить как...")){
            controller.saveDocumentAs();
        } else if(newEvent.equals("Выход")){
            controller.exit();
        } else if(newEvent.equals("О программе")){
            showAbout();
        }

    }

    public void init(){
        initGui();
        FrameListener frameListener=new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public View() {
       try{
            UIManager.setLookAndFeel("View");
       }catch (Exception e){
           ExceptionHandler.log(e);
       }
    }

    public void exit(){
        Controller controller = new Controller(this);
        controller.exit();
    }
    public void  initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);

        getContentPane().add(jMenuBar,BorderLayout.NORTH);

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
    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void selectedTabChanged(){
        if(tabbedPane.getSelectedIndex()==0){
            controller.setPlainText(plainTextPane.getText());
        } else if(tabbedPane.getSelectedIndex()==1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }
    public void undo(){
        try{
            undoManager.undo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try{
            undoManager.redo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    
    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    public boolean isHtmlTabSelected() {
        //tabbedPane.getDisplayedMnemonicIndexAt(0)==0
        if(tabbedPane.getSelectedIndex()==0){
            return true;
        } else {
            return false;
        }
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();

    }
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog( getContentPane(), "HTML Editor by Vlad Tagunkov",
                "TVI Software",
                JOptionPane.INFORMATION_MESSAGE);
    }



}
