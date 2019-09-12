package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean res = false;
        if((telNumber==null)||(telNumber.length()<10)){
            res = false;
        } else {
//            if(telNumber.matches("^\\+\\d{12}"))||(telNumber.matches("^\\d{10}"))
//                    ||( ){
//                res = true;
//            } else if() {
//
//            } else {
//                res = false;
//            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
