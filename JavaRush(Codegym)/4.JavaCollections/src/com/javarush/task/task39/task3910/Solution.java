package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        isPowerOfThree(10);
    }

    public static boolean isPowerOfThree(int n) {
        double three =  Math.log(3);
        double num = Math.log(n);
        double res = num / three;

        if(res%1==0){
            return true;
        } else {
            return false;
        }
       // System.out.println(res%1==0);


//        while (true){
//            res = n / 3;
//            if(res==1){
//                return true;
//            } else if(res < 1){
//                return false;
//            }
//            System.out.println("else" + res);
//        }



//        if (n % 3 == 0) {
//
//            return true;
//        }
       // return false;
    }
}
