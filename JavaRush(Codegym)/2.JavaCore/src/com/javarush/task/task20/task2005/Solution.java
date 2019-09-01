package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");
            InputStream inputStream = new FileInputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);

           // System.out.println(somePerson.name);
//            for(Asset elem: somePerson.assets ){
//                System.out.println(elem.getName());
//                System.out.println(elem.getPrice());
//            }


            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;

            return assets != null ? assets.equals(human.assets) : human.assets == null;


        }


        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            //return (int) (Math.random() * 100);
            return result;

        }






        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if((this.name != null) & (assets != null)){
                printWriter.println(this.name);
                printWriter.flush();

                if (this.assets.size() > 0) {
                    for (Asset current : this.assets){
                        printWriter.println(current.getName());
                        printWriter.println(current.getPrice());
                    }
                }
                printWriter.close();
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();
            String assetName;
            int flag = 0;
            while (reader.ready()){
                String data1 = reader.readLine();
                String data2 = reader.readLine();

                this.assets.add(new Asset(data1));
                this.assets.get(flag).setPrice(Double.parseDouble(data2));
                flag ++;
            }


            reader.close();

//            for(Asset elem: assets){
//                System.out.println(elem.getName());
//                System.out.println(elem.getPrice());
//            }
        }
    }
}
