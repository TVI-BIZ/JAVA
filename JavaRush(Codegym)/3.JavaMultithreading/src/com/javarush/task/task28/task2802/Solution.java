package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
    public static class AmigoThreadFactory implements ThreadFactory {
        private static AtomicInteger A = new AtomicInteger(0) ;
        private final int count = A.incrementAndGet();
        private AtomicInteger threadNumber = new AtomicInteger(0);

        String GN = Thread.currentThread().getThreadGroup().getName();


        @Override
        public Thread newThread(Runnable r) {
            AtomicInteger B = new AtomicInteger(1) ;
            Thread newThread = new Thread();
            newThread.setDaemon(false);
            newThread.setPriority(5);
            threadNumber.getAndIncrement();
            newThread.setName(GN+"-pool-"+count+"-thread-"+threadNumber);



            return newThread;
        }
    }
}
