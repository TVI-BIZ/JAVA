package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;
import java.nio.file.Files;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String filename = reader.readLine();
            InputStream fileInputStream = new FileInputStream(filename);
            //long fileSize = new File(filename).length();
            if(fileInputStream.available() < 1000){
                reader.close();
                fileInputStream.close();
                throw new DownloadException();
            }
        }
    }
    public static class DownloadException extends Exception {

    }
}
