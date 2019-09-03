package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args)throws Exception {

    }
    
    static {
        //add your code here - добавьте код тут
        try {

           reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String param = reader.readLine();

        if(param.equals("helicopter")){
            result = new Helicopter();
        } else if(param.equals("plane")){
            int passenger = Integer.parseInt(reader.readLine());
            result = new Plane(passenger);
        }
        reader.close();

    }
}
