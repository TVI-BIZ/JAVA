package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name = "Zerg1";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Zerg2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Zerg3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Zerg4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Zerg5";

        Protoss proto1 = new Protoss();
        proto1.name = "Proton1";
        Protoss proto2 = new Protoss();
        proto2.name = "Proton2";
        Protoss proto3 = new Protoss();
        proto3.name = "Proton3";

        Terran terra1 = new Terran();
        terra1.name = "Terrain1";
        Terran terra2 = new Terran();
        terra2.name = "Terrain2";
        Terran terra3 = new Terran();
        terra3.name = "Terrain3";
        Terran terra4 = new Terran();
        terra4.name = "Terrain4";


    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
