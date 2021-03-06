package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
        if(lock.tryLock()){
            try{
                actionIfLockIsFree();
            }catch (Exception e){
                lock.unlock();
            }
        } else{
            //lock.unlock();
            actionIfLockIsBusy();
        }







    }

    public void actionIfLockIsFree() {
        System.out.println("Free!");
    }

    public void actionIfLockIsBusy() {
        System.out.println("Busy!");
    }
}
