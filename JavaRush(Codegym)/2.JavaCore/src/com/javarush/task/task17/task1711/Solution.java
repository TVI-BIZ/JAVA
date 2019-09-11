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

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    int loopSteps = (args.length - 1) / 3;
                    for (int i = 1; i < loopSteps + 1; i++) {
                        String name = args[((i - 1) * 3) + 1]; //1,
                        String sex = args[((i - 1) * 3) + 2]; //
                        String data = args[(i) * 3];

                        Date dateC = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(data);
                        if (sex.equals("м")) {
                            allPeople.add(Person.createMale(name, dateC));
                        } else {
                            allPeople.add(Person.createFemale(name, dateC));
                        }
                        System.out.println(allPeople.size() - 1);

                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    int loopSteps1 = (args.length - 1) / 4;
                    for (int i = 1; i < loopSteps1 + 1; i++) {
                        String id = args[((i - 1) * 4) + 1];
                        String name = args[((i - 1) * 4) + 2]; //1,
                        String sex = args[((i - 1) * 4) + 3]; //
                        String data = args[(i) * 4];

                        Date dateU = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(data);

                        Person editedPerson = allPeople.get(Integer.parseInt(id));
                        editedPerson.setName(name);
                        editedPerson.setBirthDate(dateU);

                        if (sex.equals("м")) {
                            editedPerson.setSex(Sex.MALE);
                        } else {
                            editedPerson.setSex(Sex.FEMALE);
                        }
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    //int loopSteps2 = (args.length - 1);
                    for (int i = 1; i < args.length; i++) {
                        Person editedPerson = allPeople.get(Integer.parseInt(args[i]));
                        editedPerson.setName(null);
                        editedPerson.setSex(null);
                        editedPerson.setBirthDate(null);
                    }
                }
                    break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person editedPerson = allPeople.get(Integer.parseInt(args[i]));
                        String formDateI = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(editedPerson.getBirthDate());
                        String formSex = null;
                        String sexParam = editedPerson.getSex().toString();
                        if ((sexParam).equals("MALE")) {
                            formSex = "м";
                        } else {
                            formSex = "ж";
                        }
                        System.out.println(editedPerson.getName() + " " + formSex + " " + formDateI);
                    }
                }
                    break;

            default:
                synchronized(allPeople){ }
                break;

        }






    }
}
