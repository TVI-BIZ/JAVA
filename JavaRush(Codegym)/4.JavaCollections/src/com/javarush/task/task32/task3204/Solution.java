package com.javarush.task.task32.task3204;

import java.io.*;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        //8 symbols
        //digits and eng letters
        //must digits and letters dif reg
        //unique
        //48-57 - digits
        //65-90 - big letters
        //97-122 - small letters


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random rd = new Random();
        Random rbl = new Random();
        Random rsl = new Random();

        char dig = (char)(rd.nextInt((57-48)+1)+48);
        char bigL = (char)(rbl.nextInt((90-65)+1)+65);
        char slamL = (char)(rsl.nextInt((122-97)+1)+97);

        String pass = "";

        for(int i=0; i < 2; i++){
            pass += (char)(rd.nextInt((57-48)+1)+48);;
            pass += (char)(rbl.nextInt((90-65)+1)+65);
            pass += (char)(rsl.nextInt((122-97)+1)+97);
            pass += (char)(rbl.nextInt((90-65)+1)+65);
        }

        //System.out.println(pass);
        InputStream inputStream = new ByteArrayInputStream(pass.getBytes());
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        while (bis.available()>0){
            byteArrayOutputStream.write(bis.read());
        }


        return byteArrayOutputStream;
    }
}