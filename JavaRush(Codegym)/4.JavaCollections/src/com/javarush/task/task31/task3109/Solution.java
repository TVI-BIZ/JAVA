package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
         Solution solution = new Solution();
         Properties properties = solution.getProperties("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/properties.xml");
         properties.list(System.out);

         properties = solution.getProperties("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/NoExist");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) throws IOException {
        Properties properties  = new Properties();
        try{
            if(fileName.contains(".xml")) {
                properties.loadFromXML(new FileInputStream(fileName));
            } else {
                properties.load(new FileReader(new File(fileName)));
            }
        } catch (Exception e){

        }
        return properties;
    }
}
