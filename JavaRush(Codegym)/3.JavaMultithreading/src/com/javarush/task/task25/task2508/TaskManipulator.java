package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
   // Thread thread;
    private Thread thread ;

    @Override
    public void run() {


            try {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(100);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }catch (Exception e){

            }





    }

    @Override
    public void start(String threadName) {
        TaskManipulator taskManipulator = new TaskManipulator();
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
        //this.run();
    }

    @Override
    public void stop() {
//        System.out.println("stop");
//        System.out.println(thread.isInterrupted());
//        System.out.println(thread.getState());
        //Thread.currentThread().interrupt();
        thread.interrupt();
//        System.out.println(thread.getState());
//        System.out.println(thread.isInterrupted());
    }
}
