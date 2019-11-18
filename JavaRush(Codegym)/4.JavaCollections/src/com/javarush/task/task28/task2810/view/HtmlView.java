package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HtmlView implements View {
    //private final String filePath2 = "/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task28/task2810/view/vacancies.html";
    private final String filePath = "./4.JavaCollections/src/"
            +this.getClass().getPackage().getName().replace('.','/')+"/vacancies.html";

    private Controller controller;
    @Override
    public void update(List<Vacancy> vacancies) {
        File newFile = new File(filePath);
        String updatedContent = getUpdatedFileContent(vacancies);
        try{
            updateFile(updatedContent);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }


    }

    @Override
    public void setController(Controller controller) {

        this.controller = controller;
    }
    public void userCitySelectEmulationMethod(){

        controller.onCitySelect("Odessa");
    }


    private String getUpdatedFileContent(List<Vacancy> vacancyList){
        Document newDocument = null;
        try {
            newDocument = getDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element newElement = newDocument.getElementsByAttributeValue("class","vacancy template").first();
        Element copyNewElement = newElement;
        //System.out.println(newDocument);
        Elements insideElem = copyNewElement.children();
        System.out.println(copyNewElement.children());
        return null;
    }
    private void updateFile(String newString){
        FileOutputStream fileOutputStream = null;
        File file;
        try{
            file = new File(filePath);
            fileOutputStream = new FileOutputStream(file);
            if(!file.exists()){
                file.createNewFile();
            }
            byte[] contentinBytes = newString.getBytes();
            fileOutputStream.write(contentinBytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){

        }

    }
    protected Document getDocument() throws IOException {
        Document newDocument = null;
        File newFile = new File(filePath);
        newDocument = Jsoup.parse(newFile,"UTF-8");
        return newDocument;
    }
}
