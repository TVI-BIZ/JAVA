package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String newString = "";
        try {
            newString = bufferedReader.readLine();
        } catch (IOException e){
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            //newString =  bufferedReader.readLine();
            return readString();
        }


        return newString;
    }
    public static int readInt() throws IOException,NumberFormatException {
        int entStr = 0;
        try{
            entStr = Integer.parseInt(readString());
        } catch (NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            entStr = Integer.parseInt(readString());
        }
        return entStr;
    }

}
