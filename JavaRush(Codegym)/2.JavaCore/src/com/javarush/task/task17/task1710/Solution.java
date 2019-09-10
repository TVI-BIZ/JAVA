package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут

        String val1 = null; //0
        String val2 = null; //1
        String val3 = null; //2
        String val4 = null; //3
        String val5 = null; //4


         if(args.length == 2){
             val1 = args[0];
             val2 = args[1];
         } else if(args.length == 4){
             val1 = args[0];
             val2 = args[1];
             val3 = args[2];
             val4 = args[3];
         } else if (args.length == 5){
             val1 = args[0];
             val2 = args[1];
             val3 = args[2];
             val4 = args[3];
             val5 = args[4];
         }


        if(val1.equals("-c")){
            Date date3 = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(val4);
            if(val3.equals("м")){
                allPeople.add(Person.createMale(val2,date3));
            } else {
                allPeople.add(Person.createFemale(val2,date3));
            }
            System.out.println(allPeople.size()-1);
        } else if(val1.equals("-u")){
            Date date4 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(val5);
            Person editedPerson = allPeople.get(Integer.parseInt(val2));
            editedPerson.setName(val3);
            editedPerson.setBirthDate(date4);
            if(val4.equals("м")){
                editedPerson.setSex(Sex.MALE);
            } else {
                editedPerson.setSex(Sex.FEMALE);
            }

        } else if (val1.equals("-d")){
            Person editedPerson = allPeople.get(Integer.parseInt(val2));
            editedPerson.setName(null);
            editedPerson.setSex(null);
            editedPerson.setBirthDate(null);

        } else if(val1.equals("-i")){
            Person editedPerson = allPeople.get(Integer.parseInt(val2));
            String formDate = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).format(editedPerson.getBirthDate());
            String formSex = null;
            String sexParam = editedPerson.getSex().toString();

            if((sexParam).equals("MALE")){
                formSex = "м";
            } else {
                formSex = "ж";
            }
            System.out.println(editedPerson.getName() + " " + formSex + " " + formDate);
        }



///////////////////////WRONG VARIANT BUFFERREAADEER ENTER VALUE FROM CONSOLE STRING
        //        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //        String enteredVal  = reader.readLine();
//        String enteredVal = args[0];
//        if(enteredVal.contains("-c")){
//            String[] firstStr = enteredVal.split(" ");
//            Date date3 = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(firstStr[3]);
//            if(firstStr[2].equals("м")){
//                allPeople.add(Person.createMale(firstStr[1],date3));
//            } else {
//                allPeople.add(Person.createFemale(firstStr[1],date3));
//            }
//            System.out.println(allPeople.size());
//
//        } else if(enteredVal.contains("-u")){
//            String[] secondStr = enteredVal.split(" ");
//            Date date4 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(secondStr[4]);
//            Person editedPerson = allPeople.get(Integer.parseInt(secondStr[1]));
//            editedPerson.setName(secondStr[2]);
//            editedPerson.setBirthDate(date4);
//            if(secondStr[3].equals("м")){
//                editedPerson.setSex(Sex.MALE);
//            } else {
//                editedPerson.setSex(Sex.FEMALE);
//            }
//
//        } else if (enteredVal.contains("-d")){
//            String[] thirddStr = enteredVal.split(" ");
//            Person editedPerson = allPeople.get(Integer.parseInt(thirddStr[1]));
//            editedPerson.setName(null);
//            editedPerson.setSex(null);
//            editedPerson.setBirthDate(null);
//
//        } else if(enteredVal.contains("-i")){
//            String[] fourthStr = enteredVal.split(" ");
//            Person editedPerson = allPeople.get(Integer.parseInt(fourthStr[1]));
//            String formDate = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).format(editedPerson.getBirthDate());
//            String formSex = null;
//            String sexParam = editedPerson.getSex().toString();
//
//            if((sexParam).equals("MALE")){
//                formSex = "м";
//            } else {
//                formSex = "ж";
//            }
//            System.out.println(editedPerson.getName() + " " + formSex + " " + formDate);
//
//        }

        // TEST PRINTING
//        System.out.println(allPeople.size());
//        for(Person elem:allPeople){
//            System.out.println(elem.getName()+ " " + elem.getSex() + " " + elem.getBirthDate());
//
//        }

    }
}
