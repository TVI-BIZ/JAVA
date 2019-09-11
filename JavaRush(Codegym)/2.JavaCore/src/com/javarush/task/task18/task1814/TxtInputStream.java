package com.javarush.task.task18.task1814;

import javafx.scene.shape.Path;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream  {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        File fileLoad = new File(fileName);
        if(fileLoad.getName().endsWith(".txt")){
        } else {
            super.close();
            throw  new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        //new TxtInputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/properties.xml");
    }
}

