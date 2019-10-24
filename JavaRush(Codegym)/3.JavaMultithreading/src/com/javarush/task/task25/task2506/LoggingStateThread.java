package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    public LoggingStateThread(Thread line) {
        this.line = line;
//        line.setDaemon(true);
//        System.out.println(line.getState());

    }
    Thread line;

    @Override
    public void run() {
        State state, lastState = null;
        do {
            state = line.getState();
            if (state != lastState) {
                System.out.println(state);
                lastState = state;
            }
        } while (state != State.TERMINATED);

    }
}
