package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name="shop")
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData = new String[5];

    public static class Goods{
        public List<String> names = new LinkedList<>();

    }
}
