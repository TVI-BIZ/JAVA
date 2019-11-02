package com.javarush.task.task30.task3003;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //Thread thread = new Thread();
//        thread.interrupt();
        try {

        for(int i = 1; i < 10;i++){
            if(Thread.currentThread().isInterrupted()){
                break;
            }

            ShareItem shItem = new ShareItem();
            shItem.description=("ShareItem-"+i);
            shItem.itemId = i;

                System.out.format("Элемент 'ShareItem-%s' добавлен\n",i);
                this.queue.offer(shItem);
                Thread.sleep(100);

            if(queue.hasWaitingConsumer()){
                System.out.format("Consumer в ожидании!%n");
            }

        }

        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

    }
}
