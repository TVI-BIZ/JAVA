package com.javarush.task.task20.task2006;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать?
*/
public class Solution {
    public static class Human implements Serializable {
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
    }

    public static void main(String[] args) throws Exception {
    Human human = new Human();
        FileOutputStream fileOutputStream = new FileOutputStream("file1.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(human);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("file.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();

        Human newHuman = (Human) object;
    }
}
