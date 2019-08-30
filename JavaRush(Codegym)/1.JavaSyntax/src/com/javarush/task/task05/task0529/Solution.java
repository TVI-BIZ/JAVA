package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int c1 = 0;
        int sum = 0;

        String s1 = "0";

//        if (s1 == "сумма") {
//            System.out.println(sum);
//        } else {
//            c1 = Integer.parseInt(s1);
//            sum += c1;
//        }


//        if(reader.readLine() != "cумма"){
//            sum += Integer.parseInt(reader.readLine());
//        } else if (reader.readLine() == "cумма"){
//            System.out.println(sum);
//            break;
//        }



//        while (s1 != "сумма"){
//            c1 = Integer.parseInt(s1);
//            sum += c1;
//            s1 = reader.readLine();
//        }

        while (true)
        {
            String s = reader.readLine();
            if (s.equals("сумма")){
                break;
            } else {
                sum += Integer.parseInt(s);
            }
        }

        System.out.println(sum);

    }
}
