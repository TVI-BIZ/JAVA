package com.javarush.task.task08.task0823;

// import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        try
        {
            //String str = br.readLine();
            char[] str1 = new char[string.length()];

            for(int i=0; i<string.length(); i++)
            {
                str1[i] = Character.toLowerCase(string.charAt(i));
            }

            str1[0] = Character.toUpperCase(str1[0]);
            for(int i=0;i<string.length();i++)
            {
                if(str1[i] == ' ')
                {
                    str1[i+1] =  Character.toUpperCase(str1[i+1]);
                }
                System.out.print(str1[i]);
            }
        }
        catch(Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }







//        string = string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
//        string = string.toUpperCase();
//        System.out.println(string);




        Character charEl;


        //напишите тут ваш код
        String[] myWords = string.split(("\\W+"));

//
//        for(String elem: myWords){
//           elem =  elem.substring(0,1).toUpperCase() + elem.substring(1).toLowerCase();
//           System.out.print(elem + " ");


            //charEl = Character.toUpperCase(elem.charAt(0));
            //char[] charArray = elem.toCharArray();
            //charArray[0] = Character.toUpperCase(elem.charAt(0));
            //Character.toUpperCase(elem.charAt(0));
            //System.out.println(charArray[0]);
            //elem = new String(charArray);
            //System.out.print(elem + " ");
  //      }
//        for(String elem: myWords){
//            System.out.println(elem);
//        }

    }
}
