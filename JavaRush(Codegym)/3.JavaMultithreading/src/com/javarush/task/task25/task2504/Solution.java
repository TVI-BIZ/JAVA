package com.javarush.task.task25.task2504;



/*
Switch для нитей
*/
public class Solution  {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for(Thread elem:threads){
            Thread.State elemState = elem.getState();

            switch (elemState){
                case NEW:
                    elem.start();
                    break;
                case WAITING:
                    elem.interrupt();
                    break;
                case TIMED_WAITING:
                    elem.interrupt();
                    break;
                case BLOCKED:
                    elem.interrupt();
                    break;
                case RUNNABLE:
                    elem.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(elem.getPriority());
                    break;

            }



//            if(elemState == Thread.State.NEW){
//                elem.start();
//            } else if(elemState == Thread.State.TIMED_WAITING){
//                elem.interrupt();
//            } else if (elemState == Thread.State.RUNNABLE){
//                elem.isInterrupted();
//            } else if(elemState == Thread.State.TERMINATED){
//                System.out.println(elem.getPriority());
//            }

        }
    }

    public static void main(String[] args) {
    }


}
