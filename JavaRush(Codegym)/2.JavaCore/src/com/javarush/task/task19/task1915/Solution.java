package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);


        String result = outputStream.toString();
        System.setOut(consoleStream);


        System.out.println(result);
        fileOutputStream.write(outputStream.toByteArray());
        fileOutputStream.close();

    }


    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

