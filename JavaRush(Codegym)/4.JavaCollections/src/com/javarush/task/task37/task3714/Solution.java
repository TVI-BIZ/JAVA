package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    private static Map<String, Integer> Mapper(){
        Map<String,Integer> oneSym = new HashMap<>();
        oneSym.put("I",1);
        oneSym.put("V",5);
        oneSym.put("X",10);
        oneSym.put("L",50);
        oneSym.put("C",100);
        oneSym.put("D",500);
        oneSym.put("M",100);
        return oneSym;
    }

    private static Map<String, Integer> Mapper2(){
        Map<String,Integer> twoSym = new HashMap<>();
        twoSym.put("IV",4);
        twoSym.put("IX",9);
        twoSym.put("XL",40);
        twoSym.put("XC",90);
        twoSym.put("CD",400);
        twoSym.put("CM",900);
        return twoSym;
    }



    public static int romanToInteger(String s) {



        char[] charArray = s.toCharArray();
        int res = 0;
        int cnt = 0;

        while (charArray.length>cnt){
            if(charArray[cnt]=='I'){
                res+=1;
            }else if(charArray[cnt]=='V'){
                res+=5;
            }else if(charArray[cnt]=='X'){
                res+=10;
            }else if(charArray[cnt]=='L'){
                res+=50;
            }else if(charArray[cnt]=='C'){
                res+=100;
            }else if(charArray[cnt]=='D'){
                res+=500;
            }else if(charArray[cnt]=='M'){
                res+=1000;
            }
            cnt++;
        }
        return res;
    }
}
