package com.javarush.task.task28.task2805;

public class MyThread extends Thread {


    public MyThread() {
        for(int i = MIN_PRIORITY; i < MAX_PRIORITY+1;i++){
                this.setPriority(i);
//            if(this.getThreadGroup() != null){
//                if(i>this.getThreadGroup().getMaxPriority()){
//                this.setPriority(i);
//                }
//            } else {
//                this.setPriority(i);
//            }
        }



    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }


}
