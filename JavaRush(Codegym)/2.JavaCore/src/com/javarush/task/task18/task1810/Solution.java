package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";

        try{
           fileName = reader.readLine();
        } catch (Exception e){

        }

        try{
            FileInputStream inputStream = new FileInputStream(fileName);
        } catch (Exception e){

        }





    }

    public static class DownloadException extends Exception {

    }
}
