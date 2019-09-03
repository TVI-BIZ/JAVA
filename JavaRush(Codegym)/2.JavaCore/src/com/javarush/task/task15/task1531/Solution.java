package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) throws IOException {
        //add your code here

        int numS = n;
        BigDecimal resI = new BigDecimal("1.0");

        if (numS == 0){
            resI = BigDecimal.valueOf((long)1);
        } else if((numS > 0) &&(numS <= 150)) {
            for(long i = 1; i < numS + 1; i++){
                resI = resI.multiply(BigDecimal.valueOf(i));
                //System.out.println(resI);
            }
        } else if(numS < 0){
            resI = BigDecimal.valueOf((long)0);;
        }
        //System.out.println(resI);

        return resI.toBigInteger().toString();
    }
}
