package com.javarush.task.task14.task1417;

public class Ruble extends Money {
    public Ruble(double amount) {
        super(amount);
    }


    public double getAmount() {
        //Money su = new Money(10);

        return super.getAmount();
    }

    public String getCurrencyName(){
        return "RUB";
    }
}
