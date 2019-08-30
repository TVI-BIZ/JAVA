package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandFather1 = new Human("Pavel",true,68);
        Human grandFather2 = new Human("Petr", true,87);

        Human grandMother1 = new Human("Alisa", false, 58);
        Human grandMother2 = new Human("Olga",false,65);

        Human father = new Human("Alex",true,35,grandFather1,grandMother1);
        Human mother = new Human("Rina",false,31,grandFather2,grandMother2);

        Human child1 = new Human("Ilon",true,13,father,mother);
        Human child2 = new Human("Polli",false,8,father,mother);
        Human child3 = new Human("Vikki",false,2,father,mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);

        System.out.println(grandMother1);
        System.out.println(grandMother2);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}