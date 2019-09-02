package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution  implements Serializable  {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution(4));

        FileInputStream fileInputStream = new FileInputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");

        Solution savedObject = new Solution(15);

        while (fileInputStream.available()>0){
             fileOutputStream.write(savedObject.pattern.getBytes());
             fileOutputStream.write(savedObject.currentDate.toString().getBytes());
             fileOutputStream.write(savedObject.temperature);
             fileOutputStream.write(savedObject.string.getBytes());
        }
        fileOutputStream.close();
        Solution loadedObject = new Solution(25);

        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

//        while (reader.ready()){
//            fileInputStream.read()
//        }


    }





    private final String pattern = "dd MMMM yyyy, EEEE";
    private Date currentDate;
    private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
