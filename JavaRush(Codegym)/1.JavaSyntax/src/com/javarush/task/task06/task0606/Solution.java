package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        String s1 = reader.readLine();
        char[] ch1 = new char[s1.length()];
        ch1 = s1.toCharArray();



        int count = 0;
        int prm = 0;

        while (count < ch1.length){
            prm = ch1[count];
            if(prm % 2 == 0){
                even +=1;
            } else {
                odd +=1;
            }
            count++;
        }

        System.out.println("Even: "+even+" Odd: "+odd);



    }
}
