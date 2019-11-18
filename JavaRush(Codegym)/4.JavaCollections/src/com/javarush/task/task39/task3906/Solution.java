package com.javarush.task.task39.task3906;

/* 
Интерфейсы нас спасут!
*/
public class Solution {
    public static void main(String[] args) {
       // SecuritySystem securitySystem = new SecuritySystem();
        Switchable switchable = null;
        ElectricPowerSwitch electricPowerSwitch = new ElectricPowerSwitch(null);

        electricPowerSwitch.press();
        electricPowerSwitch.press();
    }
}
