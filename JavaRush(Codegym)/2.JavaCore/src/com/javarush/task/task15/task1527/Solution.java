package com.javarush.task.task15.task1527;

import java.io.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName));

        String[] Qstr = new String[0];
        String[] Qstr2 = new String[0];
        String[] Qstr3 = new String[0];
        String[] res1 =new String[0];
        String[] res2 = new String[5];
        Double[] res3 = new Double[5];


        int flag = 0;
        int flag2 = 0;

        while (reader2.ready()){
            String line = reader2.readLine();
            Qstr = line.split("\\?");
            Qstr2 = Qstr[1].split("&");

            for(String elem:Qstr2){
               if((elem.contains("=")) && (elem.contains("obj"))){
                   res1 = elem.split("=");
                   res3[flag] = Double.parseDouble(res1[1]);
                   res2[flag2] = res1[0];
                   //alert(Double.parseDouble(res1[1]));
                   flag++;
                   flag2++;
               } else if (elem.contains("=")) {
                   res1 = elem.split("=");
                   res2[flag2] = res1[0];
                   flag2++;
                   //alert(res1[0]);
               } else {
                   res2[flag2] = elem;
                   //System.out.println(elem);
                   flag2++;
               }
            }
        }
        for(String elem:res2 ){
            System.out.print(elem + " ");
        }

        if(res3.length != 0){
            for(Double elem2:res3 ){
                alert(elem2);
            }
        }






    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }


    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
