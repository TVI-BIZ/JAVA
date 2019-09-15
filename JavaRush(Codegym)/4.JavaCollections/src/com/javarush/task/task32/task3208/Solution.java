package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;
    public static String UNIC_BINDING_NAME1 = "server.animals.cat";
    public static String UNIC_BINDING_NAME2 = "server.animals.dog";

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код

            try {


                registry = LocateRegistry.createRegistry (2099);
                Cat cat = new Cat("Murzik");
                Dog dog = new Dog("Sherik");
               Remote remCat =  UnicastRemoteObject.exportObject(cat,2099);
               Remote remDog =  UnicastRemoteObject.exportObject(dog,2099);


               registry.bind(UNIC_BINDING_NAME1,remCat);
               registry.bind(UNIC_BINDING_NAME2,remDog);


            } catch (Exception e) {
               e.printStackTrace();
               // System.err.println(e.getStackTrace());
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(5000);
        // Start the client
        CLIENT_THREAD.start();
    }
}