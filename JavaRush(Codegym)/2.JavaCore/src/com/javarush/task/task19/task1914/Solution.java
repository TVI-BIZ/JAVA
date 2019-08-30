package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

        String result = outputStream.toString();
        System.setOut(consoleStream);

        String[] subs = result.split(" ");



        StringBuilder stringBuilder = new StringBuilder(result);
//        char a = stringBuilder.charAt(0);
//        char b = stringBuilder.charAt(4);
        //char sym = stringBuilder.charAt(2);
        int res = 0;
//        int aInt = Integer.parseInt(Character.toString(a));
//        int bInt = Integer.parseInt(Character.toString(b));


        int aInt = Integer.parseInt(subs[0]);
        int bInt = Integer.parseInt(subs[2]);
        char sym = subs[1].charAt(0);

        if (sym == '+'){
            res = aInt + bInt;
        } else if (sym == '-'){
            res = aInt - bInt;
        } else if (sym == '*'){
            res = aInt * bInt;
        }



       String resStrings = stringBuilder.toString();

        System.out.println(resStrings.replace("= ","= " + res ));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

