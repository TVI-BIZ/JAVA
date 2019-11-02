package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread thread = new Thread();
        thread.interrupt();
        try {
            thread.sleep(450);
            while (true){
                queue.take();
                //System.out.println("Processing item.toString()");
                System.out.format("Processing %s\n", queue.take().description);
            }

        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

    }
}
