package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));



        while (true){

            String text = reader.readLine();
            if(text.equals("exit")){
                writer.write(text);
                break;
            }
            writer.write(text);
            writer.newLine();
        }

        writer.close();
        reader.close();


    }
}
