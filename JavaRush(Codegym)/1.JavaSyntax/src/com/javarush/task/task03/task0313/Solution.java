package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String mama = "Мама";
        String wash = "Мыла";
        String frame = "Раму";
        String s1 = mama+wash+frame;
        String s2 = mama+frame+wash;
        String s3 = wash+frame+mama;
        String s4 = wash+mama+frame;
        String s5 = frame+mama+wash;
        String s6 = frame+wash+mama;




          System.out.println(mama+wash+frame);
          System.out.println(mama+frame+wash);
        System.out.println(wash+frame+mama);
        System.out.println(wash+mama+frame);
        System.out.println(frame+mama+wash);
        System.out.println(frame+wash+mama);

    }
}
