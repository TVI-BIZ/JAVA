package com.javarush.task.task24.task2403;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.server.RemoteObject;
import java.util.ArrayDeque;
import java.util.EventListener;

/* 
Так-с... сопоставим
*/
public class Solution {
    public static class A implements Serializable {
    }

    public static class B implements Remote {
        protected final B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }
    }

    public static class C extends ArrayDeque {
        @Override
        public ArrayDeque clone() {
            return super.clone();
        }

    }

    public static class D implements EventListener {
        protected D clone() throws CloneNotSupportedException {
            return (D) super.clone();
        }
    }

    


    public static void main(String[] args) {

    }
}
