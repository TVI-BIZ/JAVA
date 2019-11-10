package com.javarush.task.task35.task3512;

public class Generator<T> {

    public Generator(Class<T> tClass) {
        this.tClass = tClass;
    }
    Class<T> tClass;

    T newInstance() throws IllegalAccessException, InstantiationException {
           return tClass.newInstance();

    }

}
