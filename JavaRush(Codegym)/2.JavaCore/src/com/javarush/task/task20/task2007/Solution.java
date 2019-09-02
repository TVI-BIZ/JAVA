package com.javarush.task.task20.task2007;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать JavaRush?
*/
public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
        public JavaRush (){

        }
        public JavaRush(User... users){
            if( users != null){
                this.users.addAll(Arrays.asList(users));
            }
        }

    }

    public static void main(String[] args) {
        JavaRush javaRush = new JavaRush();


    }
}
