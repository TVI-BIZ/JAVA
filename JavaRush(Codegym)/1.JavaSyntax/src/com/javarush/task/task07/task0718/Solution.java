package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> listS = new ArrayList<>();
        int[] newArr = new int[10];

        int cn = 0;
        while (cn < 10){
            listS.add(reader.readLine());
            cn++;
        }

        for(int i = 0; i < 10; i++){
            //System.out.println(listS.get(i).length());
            newArr[i] = listS.get(i).length();
        }

        for (int j=0; j < newArr.length; j++){
            //System.out.println(newArr[j]);
            if(j+1<10) {
                    if (newArr[j] < newArr[j + 1]) {

                    } else {
                        System.out.println(j + 1);
                        break;
                    }
            }
        }


    }
}

