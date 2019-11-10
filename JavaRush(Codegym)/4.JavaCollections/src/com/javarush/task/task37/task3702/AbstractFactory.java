package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.KidGirl;
import com.javarush.task.task37.task3702.female.TeenGirl;
import com.javarush.task.task37.task3702.female.Woman;
import com.javarush.task.task37.task3702.male.KidBoy;

public interface AbstractFactory {
    public<T extends Human> T getPerson(int age);
}
