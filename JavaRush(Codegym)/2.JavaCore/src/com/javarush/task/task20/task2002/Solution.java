package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("TMP.txt", null);
            OutputStream outputStream = new FileOutputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");
            InputStream inputStream = new FileInputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            User user = new User();
            user.setFirstName("Oleg");
            user.setLastName("Ivanov");
            user.setBirthDate(dateFormat.parse("23.05.1980"));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            user = new User();
            user.setFirstName("Olga");
            user.setLastName("Sidorova");
            user.setBirthDate(dateFormat.parse("11.02.1980"));
            user.setMale(false);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);



            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String isUsersListEmpty = users != null ? "yes" : "no";
            writer.println(isUsersListEmpty);
            writer.flush();

            if(users != null ){
                int flag = 0;
                for(User elem: users){
                   writer.println(elem.getFirstName());
                   writer.println(elem.getLastName());

                   long dateTime = elem.getBirthDate().toInstant().toEpochMilli();
                   String dateTimeString = Long.toString(dateTime);

                   writer.println(dateTimeString);
                   writer.println(elem.isMale());

                   User.Country country = users.get(flag).getCountry();
                   writer.println(country);

                   flag++;
                }
            }
            outputStream.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isListEmpty = reader.readLine();

            if(isListEmpty.equals("yes")){
                while (reader.ready()){
                    String data1 = reader.readLine();
                    String data2 = reader.readLine();
                    String data3 = reader.readLine();
                    String data4 = reader.readLine();
                    String data5 = reader.readLine();


                    User user = new User();
                    user.setFirstName(data1);
                    user.setLastName(data2);

                    Date date = new Date(Long.parseLong(data3));
                    user.setBirthDate(date);

                    user.setMale(Boolean.parseBoolean(data4));

                    if(data5.equals("UKRAINE")){
                        user.setCountry(User.Country.UKRAINE);
                    } else if (data5.equals("RUSSIA")){
                        user.setCountry(User.Country.RUSSIA);
                    } else if (data5.equals("OTHER")){
                        user.setCountry(User.Country.OTHER);
                    }


//                    System.out.println(user.getFirstName());
//                    System.out.println(user.getLastName());
//                    System.out.println(user.getBirthDate());
//                    System.out.println(user.isMale());
//                    System.out.println(user.getCountry());


                    users.add(user);
                }

            }

        reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
