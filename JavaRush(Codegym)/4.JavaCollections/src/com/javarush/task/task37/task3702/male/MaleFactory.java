package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {
    @Override
    public <T extends Human> T getPerson(int age) {
                if(age<=KidBoy.MAX_AGE){
            return (T) new KidBoy();
        }else if(age>= KidBoy.MAX_AGE && age<=TeenBoy.MAX_AGE){
            return (T) new TeenBoy();
        } else {
            return (T) new Man();
        }
    }

//    public<T extends Human> T getPerson(int age){
//        if(age<=KidBoy.MAX_AGE){
//            return (T) new KidBoy();
//        }else if(age>= KidBoy.MAX_AGE && age<=TeenBoy.MAX_AGE){
//            return (T) new TeenBoy();
//        } else {
//            return (T) new Man();
//        }
//    }


}
