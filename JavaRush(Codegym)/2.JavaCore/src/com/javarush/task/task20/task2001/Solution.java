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

            ivanov.save(outputStream);
            outputStream.flush();




            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

            if (ivanov.equals(somePerson)) System.out.println("Равны");
            else System.out.println("Не равны");


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
            String isNamePresneted = name != null ? "yes": "no";
            String isAssetsPresented = assets != null ? "yes": "no";

            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(isNamePresneted);

            if(assets == null){
                writer.println(name);
                writer.println(isAssetsPresented);

                writer.flush();
            } else {
                writer.println(name);
                writer.println(isAssetsPresented);
                writer.flush();
                for(Asset elem: assets){
                    writer.println(elem.getName());
                    writer.println(elem.getPrice());
                }
                writer.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isNamePresented = reader.readLine();

            if(isNamePresented.equals("yes")){
                name = reader.readLine();
            }

            String isAssetPresented = reader.readLine();
            if(isAssetPresented.equals("yes")){
                while (reader.ready()){
                    String data = reader.readLine();
                    String data2 = reader.readLine();
                    assets.add(new Asset(data,Double.parseDouble(data2)));
                }
            }
//            for (Asset elem: assets){
//                System.out.println(elem.getName());
//                System.out.println(elem.getPrice());
//            }






        }
    }
}
