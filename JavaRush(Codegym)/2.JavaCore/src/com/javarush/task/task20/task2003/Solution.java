package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        //properties = new HashMap<String, String>((Map)load(fileInputStream););
        Properties myprop = new Properties();

//        for(String name: myprop.stringPropertyNames()){
//            properties.put(name,)
//        }
        myprop.putAll(properties);

        save(fileOutputStream);





    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        //PrintWriter printWriter = new PrintWriter(outputStream);
        Properties myprop = new Properties();
        myprop.store(outputStream,null);


//        for(Map.Entry<String,String> elem: properties.entrySet()){
//            String key = elem.getKey();
//            String value = elem.getValue();
//
//            printWriter.println(key+ " : "+ value);
//        }
//        printWriter.flush();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//        while (bufferedReader.ready()){
//            String data = bufferedReader.readLine();
//            String[] tempStr = data.split(" : ");
//            properties.put(tempStr[0],tempStr[1]);
//        }
//        bufferedReader.close();
        Properties myprop = new Properties();
        myprop.load(inputStream);

    }

    public static void main(String[] args) {
    }
}
