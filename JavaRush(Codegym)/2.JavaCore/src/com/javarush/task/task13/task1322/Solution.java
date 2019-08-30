package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String writeData;
        BufferedWriter writer3 = new BufferedWriter(new OutputStreamWriter(System.out));


        try{
            String fileName = reader.readLine();
            //OutputStream outputStream = new FileOutputStream(fileName);

            do{
                writeData = reader.readLine();
                writer.write(writeData+"\n");

            } while (!writeData.equals("exit"));


            //outputStream.close();
           // writer.close();
            reader.close();
            writer3.close();


        } catch (Exception e){
            //System.out.println(e);

        }

    }
}
