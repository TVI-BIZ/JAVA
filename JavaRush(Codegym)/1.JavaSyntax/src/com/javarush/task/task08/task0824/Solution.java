package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        List<Human> noChild = new ArrayList<>();

        Human child1 = new Human("ch1",true,5,noChild);
        Human child2 = new Human("ch2",false,7,noChild);
        Human child3 = new Human("ch3",true,8,noChild);
        List<Human> childrenM = new ArrayList<>();
        childrenM.add(child1);
        childrenM.add(child2);
        childrenM.add(child3);

        Human mother = new Human("father",true,25,childrenM);
        Human father = new Human("mother",false,23,childrenM);
        List<Human> parentsM = new ArrayList<>();
        parentsM.add(mother);
        List<Human> parentsF = new ArrayList<>();
        parentsF.add(father);

        Human grandF1 = new Human("GF1",true,75,parentsM);
        Human grandF2 = new Human("GF2",true,80,parentsF);
        Human grandM1 = new Human("GM1",false,70,parentsM);
        Human grandM2 = new Human("GM2",false,75,parentsF);




        System.out.println( grandF1.toString());
        System.out.println( grandF2.toString());
        System.out.println( grandM1.toString());
        System.out.println( grandM2.toString());

        System.out.println( mother.toString());
        System.out.println( father.toString());

        System.out.println( child1.toString());
        System.out.println( child2.toString());
        System.out.println( child3.toString());

    }

    public static class Human {
        //напишите тут ваш код
       public String name;
       public boolean sex;
       public int age;
       List<Human> children = new ArrayList<>();

      public Human(String name, boolean sex, int age, List<Human> children){
          this.name = name;
          this.sex = sex;
          this.age = age;
          this.children = children;
      }




        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
