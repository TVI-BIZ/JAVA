package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();


    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(args[0]);
        String  BigStr = "";

        while (fileReader.ready()){
            int data = fileReader.read();
            BigStr += (char) data;

        }
        fileReader.close();

        String[] strDiv = BigStr.split("\n");

        String dateNums = "";
        String nameChars = "";
        Date date = null;
        int flag = 0;

        for(String elem: strDiv){
                nameChars = elem.replaceAll("\\d", " ").trim();
                dateNums = elem.replaceAll("[^\\d]", " " ).trim();
                date = new SimpleDateFormat("dd MM yyyy").parse(dateNums);
                Person person = new Person(nameChars,date);
                PEOPLE.add(flag,person);
                flag++;
        }
        for(Person person: PEOPLE){
            System.out.println(person.getName());
            System.out.println(person.getBirthDate());
        }

    }

}
