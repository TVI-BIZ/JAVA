package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket mySocket = new Socket(url.getHost(),80);
            OutputStream outputStream = mySocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream,true);

            out.println( "GET "+url.getFile()+" HTTP/1.1\r\n");
            out.println("Host: "+url.getHost()+"\r\n\r\n");
            out.flush();


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}