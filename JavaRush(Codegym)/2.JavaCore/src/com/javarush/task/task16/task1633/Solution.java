package com.javarush.task.task16.task1633;

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();


    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);
        //TestedThread common2 = (TestedThread) (Thread.setDefaultUncaughtExceptionHandler(handler));

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.start();
        threadB.start();

        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread{
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            //new TestedThread(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //System.out.println(e.fillInStackTrace());
                //System.out.;
                throw new RuntimeException("My exception message");

            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
