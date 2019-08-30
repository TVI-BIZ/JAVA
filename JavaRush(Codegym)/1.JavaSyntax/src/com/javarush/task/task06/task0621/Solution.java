package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        String grandMotherName = reader.readLine();

        String fatherName = reader.readLine();
        String motherName = reader.readLine();




        Cat grandFather = new Cat(grandFatherName);
        Cat grandMother = new Cat(grandMotherName);

        Cat catMother = new Cat(grandMother,motherName);
        Cat catFather = new Cat(fatherName,grandFather);



        String sanName = reader.readLine();
        String daughterName = reader.readLine();


        Cat catSan = new Cat(sanName,catFather,catMother);
        Cat catDaughter = new Cat(daughterName, catFather,catMother);

        System.out.println(grandFather);
        System.out.println(grandMother);

        System.out.println(catFather);
        System.out.println(catMother);

        System.out.println(catSan);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentMother;
        private Cat parentFather;
        private Cat grandFather;
        private Cat grandMother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentFather){
            this.name = name;
            this.parentFather = parentFather;
        }

        Cat(Cat parentMother, String name){
            this.name = name;
            this.parentMother = parentMother;
        }



        Cat(String name, Cat parentFather, Cat parentMother) {
            this.name = name;
            this.parentFather = parentFather;
            this.parentMother = parentMother;
        }

        @Override
        public String toString() {
            if (parentFather == null && parentMother == null)
                return "The cat's name is " + name + ", no mother, no father";
            else if (parentFather == null && parentMother != null)
                return "The cat's name is " + name + ", mother is " + parentMother.name + ", no father";
            else if(parentFather != null && parentMother == null)
                return "The cat's name is " + name + ", no mother" +", father is " + parentFather.name;
            else if(parentMother != null && parentFather == null)
                return "The cat's name is " + name  + ", mother is " + parentMother.name +", no father";
            else if(parentMother != null && parentFather != null)
                return "The cat's name is " + name + ", mother is " + parentMother.name + ", father is " + parentFather.name;
            else
                return "Nothing info about that cat!";

        }
    }

}
