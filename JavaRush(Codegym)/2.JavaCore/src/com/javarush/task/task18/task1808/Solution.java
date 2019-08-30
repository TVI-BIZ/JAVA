package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static <ArrayListList> void main(String[] args) throws Exception {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(file1);
        FileOutputStream outStream2 = new FileOutputStream(file2);
        FileOutputStream outStream3 = new FileOutputStream(file3);

        int size1 = 0;
        int size2 = 0;



        if(inputStream1.available()%2 != 0){
            size1 = inputStream1.available()/2; // smaller - 7
            size2 = inputStream1.available() - inputStream1.available()/2; // bigger - 8



            byte[] buffer1 = new byte[size1]; // small
            byte[] buffer2 = new byte[size2]; //big


            while (inputStream1.available()>0){
                int counter2 = inputStream1.read(buffer2); // big
                int counter1 = inputStream1.read(buffer1); //small


                //System.out.println("buf1 " + buffer1.length + " buf2 " + buffer2.length);

                outStream2.write(buffer2);
                outStream3.write(buffer1);
            }
            inputStream1.close();
            outStream2.close();
            outStream3.close();


        } else {
            size1 = inputStream1.available()/2;
            size2 = inputStream1.available()/2;

            byte[] buffer2 = new byte[size1];
            byte[] buffer3 = new byte[size2];


            byte[] buffer1 = new byte[inputStream1.available()];
            while (inputStream1.available()>0){
                int count1 = inputStream1.read(buffer1);
                int count2 = inputStream1.read(buffer2);
                int count3 = inputStream1.read(buffer3);

                outStream2.write(buffer1,0,size1);
                outStream2.close();
                outStream3.write(buffer1,size2,size1);
                outStream3.close();

            }



            int cnt = buffer1.length;

//            byte[] buffer2 = new byte[cnt/2];
//            byte[] buffer3 = new byte[cnt/2];
//
//
//            ArrayList<Byte> byte2 = new ArrayList<>();
//            ArrayList<Byte> byte3 = new ArrayList<>();
//
//            for(int i = 0; i < cnt/2; i++){
//                //System.out.println(buffer1[i]);
//                byte2.add(buffer1[i]);
//            }
//            for(int i = 0; i < cnt/2; i++){
//                byte3.add(buffer1[cnt/2 + i]);
//            }
//
//            byte[] result2 = new byte[byte2.size()];
//            byte[] result3 = new byte[byte3.size()];
//
//            for(int i =0 ; i < byte2.size(); i++){
//                System.out.println(byte2.get(i).byteValue());
//                result2[i] = byte2.get(i).byteValue();
//            }
//            System.out.println("Break");
//            for(int i =0 ; i < byte3.size(); i++){
//                System.out.println(byte3.get(i).byteValue());
//                result3[i] = byte3.get(i).byteValue();
//            }

//            outStream2.write(buffer1,0,cnt/2);
//            outStream2.close();
//            outStream3.write(buffer1,cnt/2,cnt/2);
//            outStream3.close();


//            while (inputStream1.available()>0){
//                int counter1 = inputStream1.read(buffer1);
//                //int counter2 = inputStream1.read(buffer2);
//
//                outStream2.write(result2);
//                outStream3.write(result3);
//
//            }





            inputStream1.close();
            outStream2.close();
            outStream3.close();
        }



//        byte[] buffer1 = new byte[size1];
//        byte[] buffer2 = new byte[size2];
//
//
//        while (inputStream1.available()>0){
//            int counter1 = inputStream1.read(buffer1);
//            int counter2 = inputStream1.read(buffer2);
//            //System.out.println("buf1 " + buffer1.length + " buf2 " + buffer2.length);
//
//            outStream2.write(buffer2,0,counter2);
//            outStream3.write(buffer1,0,counter1);
//
//        }
//
//
//
//
//
//        inputStream1.close();
//        outStream2.close();
//        outStream3.close();
    }
}
