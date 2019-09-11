package com.javarush.task.task22.task2201;

import java.util.LinkedList;
import java.util.List;

/*
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        if(string ==null) {
            //throw new TooShortStringException();
        }
        int tabCount = string.length() - string.replaceAll("\t","").length();
        int counter = 0;
        String resString = null;
        List<Integer> tabPositions = new LinkedList<>();
        if(tabCount >= 2){
            for(int i = 0; i < string.length();i++){
                if(string.charAt(i) == '\t'){
                    tabPositions.add(counter);
                }
                counter++;
            }
            if(tabPositions.size() >= 2){
                resString = string.substring(tabPositions.get(0)+1,tabPositions.get(1));
            } else {
                resString = string.substring(tabPositions.get(0)+1);
            }
        } else {
            //throw  new TooShortStringException();
        }
        return resString;


        //return null;
    }
}
