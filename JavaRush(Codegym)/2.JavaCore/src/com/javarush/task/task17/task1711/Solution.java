package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут

        if(args[0].equals("-c")){
            int loopSteps = (args.length-1)/3;
            for (int i = 1; i < loopSteps+1;i++){
                String name = args[((i-1)*3)+1]; //1,
                String sex = args[((i-1)*3)+2]; //
                String data = args[(i)*3];

                Date dateC = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(data);
                if(sex.equals("м")){
                    allPeople.add(Person.createMale(name,dateC));
                } else {
                    allPeople.add(Person.createFemale(name,dateC));
                }
                System.out.println(allPeople.size()-1);
            }
        } else if(args[0].equals("-u")){
            int loopSteps = (args.length-1)/4;
            for (int i = 1; i < loopSteps+1;i++){
                String id = args[((i-1)*4)+1];
                String name = args[((i-1)*4)+2]; //1,
                String sex = args[((i-1)*4)+3]; //
                String data = args[(i)*4];

                Date dateU = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(data);

                Person editedPerson = allPeople.get(Integer.parseInt(id));
                editedPerson.setName(name);
                editedPerson.setBirthDate(dateU);

                if(sex.equals("м")){
                    editedPerson.setSex(Sex.MALE);
                } else {
                    editedPerson.setSex(Sex.FEMALE);
                }
            }
        } else if (args[0].equals("-d")){
            int loopSteps = (args.length-1);
            for (int i = 0; i < loopSteps;i++){
                Person editedPerson = allPeople.get(i);
                editedPerson.setName(null);
                editedPerson.setSex(null);
                editedPerson.setBirthDate(null);
            }
        } else if (args[0].equals("-i")){
            for (int i = 0; i < args.length-1;i++){
                Person editedPerson = allPeople.get(i);
                String formDateI = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(editedPerson.getBirthDate());
                String formSex = null;
                String sexParam = editedPerson.getSex().toString();

                if((sexParam).equals("MALE")){
                    formSex = "м";
                } else {
                    formSex = "ж";
                }
                System.out.println(editedPerson.getName() + " " + formSex + " " + formDateI);

            }
        }




//        if ((args.length - 1)%4 == 0){
//
//
//        } else if ((args.length - 1)%3 == 0){
//
//
//        } else if ((args.length - 1)%2 == 0){
//
//
//        }
//
//
//
//
//
//
//
//
//        String val1 = null; //0
//        String val2 = null; //1
//        String val3 = null; //2
//        String val4 = null; //3
//        String val5 = null; //4
//
//
//        if(args.length == 2){
//            val1 = args[0];
//            val2 = args[1];
//        } else if(args.length == 4){
//            val1 = args[0];
//            val2 = args[1];
//            val3 = args[2];
//            val4 = args[3];
//        } else if (args.length == 5){
//            val1 = args[0];
//            val2 = args[1];
//            val3 = args[2];
//            val4 = args[3];
//            val5 = args[4];
//        }
//
//
//        if(val1.equals("-c")){
//            Date date3 = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(val4);
//            if(val3.equals("м")){
//                allPeople.add(Person.createMale(val2,date3));
//            } else {
//                allPeople.add(Person.createFemale(val2,date3));
//            }
//            System.out.println(allPeople.size()-1);
//        } else if(val1.equals("-u")){
//            Date date4 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(val5);
//            Person editedPerson = allPeople.get(Integer.parseInt(val2));
//            editedPerson.setName(val3);
//            editedPerson.setBirthDate(date4);
//            if(val4.equals("м")){
//                editedPerson.setSex(Sex.MALE);
//            } else {
//                editedPerson.setSex(Sex.FEMALE);
//            }
//
//        } else if (val1.equals("-d")){
//            Person editedPerson = allPeople.get(Integer.parseInt(val2));
//            editedPerson.setName(null);
//            editedPerson.setSex(null);
//            editedPerson.setBirthDate(null);
//
//        } else if(val1.equals("-i")){
//            Person editedPerson = allPeople.get(Integer.parseInt(val2));
//            String formDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(editedPerson.getBirthDate());
//            String formSex = null;
//            String sexParam = editedPerson.getSex().toString();
//
//            if((sexParam).equals("MALE")){
//                formSex = "м";
//            } else {
//                formSex = "ж";
//            }
//            System.out.println(editedPerson.getName() + " " + formSex + " " + formDate);
//        }

        // TEST PRINTING
//        System.out.println(allPeople.size());
//        for(Person elem:allPeople){
//            System.out.println(elem.getName()+ " " + elem.getSex() + " " + elem.getBirthDate());
//
//        }

    }
}
