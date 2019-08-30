package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream(args[0]);

        //FileInputStream inputStream = new FileInputStream("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/f1.txt");
        int cntS = 0;
        int cntSym = 0;

        while (inputStream.available() > 0){
            int data = inputStream.read();
            //System.out.println(data);
            if(data == 32){
                cntS ++;
            }else if ((data >= 33)&(data<=127)) {
                cntSym ++;
            }
        }
//        System.out.println(cntS);
//        System.out.println(cntSym);
        double totalSym = cntSym+cntS;

        double res = (cntS/totalSym)*100;
        //System.out.println(res);
        //Math.round(res*100)/100.0;
        //System.out.println(cntSym);
        System.out.println(Math.round(res*100)/100.0);
        inputStream.close();
    }
}
