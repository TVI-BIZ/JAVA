package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
        //Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL downURL = new URL(urlString);
        InputStream inputStream = downURL.openStream();

        Path tempFile = Files.createTempFile("tempF-",".tmp");
        Files.copy(inputStream,tempFile, StandardCopyOption.REPLACE_EXISTING);

        String oldName = (new File(urlString)).getName();
        oldName = downloadDirectory.toString() +"/"+ oldName;
        Path newFullPath = Paths.get(oldName);

        Files.move(tempFile,newFullPath,StandardCopyOption.REPLACE_EXISTING);

        return newFullPath;
    }
}
