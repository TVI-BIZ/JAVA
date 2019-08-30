package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread sp1 = new SpecialThread();
        SpecialThread sp2 = new SpecialThread();
        SpecialThread sp3 = new SpecialThread();
        SpecialThread sp4 = new SpecialThread();
        SpecialThread sp5 = new SpecialThread();

        Thread st1 = new Thread(sp1);
        Thread st2 = new Thread(sp2);
        Thread st3 = new Thread(sp3);
        Thread st4 = new Thread(sp4);
        Thread st5 = new Thread(sp5);

        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);



    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
