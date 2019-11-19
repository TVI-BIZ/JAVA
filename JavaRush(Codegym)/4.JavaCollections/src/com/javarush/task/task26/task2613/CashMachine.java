package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        try {
//            String currencyCode = ConsoleHelper.askCurrencyCode();
//            String[] moneyDigitsArr = ConsoleHelper.getValidTwoDigits(currencyCode);
//            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//            currencyManipulator.addAmount(Integer.parseInt(moneyDigitsArr[0]),Integer.parseInt(moneyDigitsArr[1]));
//            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//            currencyManipulator.getTotalAmount();
            ConsoleHelper.askOperation();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
