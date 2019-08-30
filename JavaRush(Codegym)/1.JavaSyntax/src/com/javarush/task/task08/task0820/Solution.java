package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        //System.out.println("Pets Set");
        printPets(pets);

        removeCats(pets, cats);
//        System.out.println("Remove cats");
//        System.out.println(pets.size());
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());

        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        Set<Dog> resultDog = new HashSet<Dog>();
        resultDog.add(new Dog());
        resultDog.add(new Dog());
        resultDog.add(new Dog());

        return resultDog;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        Set<Object> resultObj = new HashSet<Object>();
        for(Cat elem: cats){
            resultObj.add(elem);
        }
        for(Dog elemDog: dogs){
            resultObj.add(elemDog);
        }

        return resultObj;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        pets.removeAll(cats);

//        Set<Object> petsCopy = new HashSet<>(pets);
//        //petsCopy = pets;
//        System.out.println("petsCopy");
//        System.out.println(petsCopy.size());
//
//        for(Object pet:pets){
//            for (Cat cat: cats){
//                if(pet == cat){
//                    petsCopy.remove(pet);
//                }
//            }
//        }
        //pets.clear();
//        pets = new HashSet<>();
//        pets = new HashSet<>(petsCopy);
//        pets = petsCopy;
//
//
//        System.out.println("pets after cats removed");
//        for(Object elem: pets){
//            System.out.println(elem);
//        }
        //System.out.println(pets.size());

    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for(Object pet: pets){
            System.out.println(pet);
        }
    }

    //напишите тут ваш код
    public static class Cat{
        public Cat(){

        }

    }
    public static class Dog {
        public Dog(){

        }

    }
}
