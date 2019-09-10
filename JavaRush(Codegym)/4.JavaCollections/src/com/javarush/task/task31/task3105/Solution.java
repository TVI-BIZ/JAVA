package com.javarush.task.task31.task3105;

import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        String fileName = args[0];
//        String zipFileName = args[1];

        String fileName = "/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/fert.txt";
        String zipFileName = "/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/Archive.zip";
        ZipFile zipFile = new ZipFile(zipFileName);

        FileInputStream fileInputStream = new FileInputStream(zipFileName);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
        ZipEntry zipEntry;

        while ((zipEntry = zipInputStream.getNextEntry()) != null){
            System.out.println(zipEntry.getName());
            InputStream is = zipFile.getInputStream(zipEntry);
            Files.copy(is, Paths.get("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f11.txt"), StandardCopyOption.REPLACE_EXISTING);

        }




        /////////////////////////////////////////////////////////////////
//        System.out.println(zipInputStream.getNextEntry());
//        System.out.println(zipInputStream.read());
//
//        ZipFile zipFile = new ZipFile(zipFileName);
//        Enumeration<? extends ZipEntry> entries = zipFile.entries();
//        //System.out.println(entries);
//
//        while (entries.hasMoreElements()){
//            ZipEntry entry = entries.nextElement();
//            //System.out.println(entry.getName());
//            if(entry.getName() != null){
//                InputStream stream = zipFile.getInputStream(entry);
//                System.out.println(stream.toString());
//            }
//
//        }
////////////////////////////////////////////////////////////////////////////////

//        while (entries.hasMoreElements()){
//            ZipEntry entry = entries.nextElement();
//            InputStream stream = zipFile.getInputStream(entry);
//            InputStreamReader reader = new InputStreamReader(stream);
//            Scanner inputStream = new Scanner(reader);
//            inputStream.nextLine();
//
//            while (inputStream.hasNext()){
//                String data = inputStream.nextLine();
//                System.out.println(data);
//                //String[] line = data.split("\n");
//            }
//            inputStream.close();
//            stream.close();
//        }
//        zipFile.close();



        FileOutputStream fileOutputStream = new FileOutputStream(zipFileName);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);





    }
}
