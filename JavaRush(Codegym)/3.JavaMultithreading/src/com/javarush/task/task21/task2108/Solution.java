package com.javarush.task.task21.task2108;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Tree clone() throws CloneNotSupportedException {
           String name =  this.getName();
           String[] branch2 =  new String[this.branches.length];
           String[] branch3 = Arrays.stream(this.branches).toArray(String[]::new);

           Tree tree = new Tree(name,branch3);
           //or this variant.
           for(int i = 0; i < branch2.length;i++){
               branch2[i] = this.branches[i];
           }
            Tree tree2 = new Tree(name,branch2);


           return tree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tree)) return false;
            Tree tree = (Tree) o;
            return Arrays.equals(getBranches(), tree.getBranches());
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(getBranches());
        }
    }
}
