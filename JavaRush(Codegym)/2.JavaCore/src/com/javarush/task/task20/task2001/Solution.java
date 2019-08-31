package com.javarush.task.task20.task2001;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1N.txt", null);
            OutputStream outputStream = new FileOutputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f2.txt");
            InputStream inputStream = new FileInputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f2.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            //Human sidorov = new Human("Sidorov", new Asset("home", 999_999.99), new Asset("car", 2999.99));

            ivanov.save(outputStream);
            //sidorov.save(outputStream);
            outputStream.flush();



            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {

        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }


        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String isNamePresented = this.name != null ? "yes": "no";
            outputStream.write((isNamePresented + " ").getBytes());
            outputStream.flush();

            if( this.name != null){
                outputStream.write(this.name.getBytes());
            }

            String isAssetsPresented = this.assets != null ? "yes": "no";
            outputStream.write((" " +isAssetsPresented ).getBytes());
            outputStream.flush();

            if(this.assets != null){
                for(Asset elem:assets){
                    outputStream.write(" ".getBytes());
                    outputStream.write(elem.getName().getBytes());
                    outputStream.write(" ".getBytes());
                    outputStream.write(String.valueOf((int)elem.getPrice()).getBytes());
                }
            }
            outputStream.flush();
            outputStream.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String bigStr = "";
           while (inputStream.available()>0){
               int data = inputStream.read();
               bigStr += (char) data;
           }
           inputStream.close();
           String[] trimStr = bigStr.split(" ");

           String isNamePresented = trimStr[0];
           if(isNamePresented.equals("yes")){
               this.name = trimStr[1];
           }

           String isAssetsPresented = trimStr[2];
           if(isAssetsPresented.equals("yes"))
                {
                    for(int i = 0; i < (trimStr.length-3)/2; i++)
                        {
                           int n = (i*2)+3; // 3,5
                           int k = (i*2)+4; // 4,6
                           this.assets.add(i,new Asset(trimStr[n],Double.parseDouble(trimStr[k])));
                        }

                 }
            //Test if our assets array is good after loading
//           for(Asset elem: this.assets){
//               System.out.println(elem.getName());
//               System.out.println(elem.getPrice());
//           }

        }


    }
}
