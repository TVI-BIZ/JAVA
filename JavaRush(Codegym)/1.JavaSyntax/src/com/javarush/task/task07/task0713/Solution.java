package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listNew = new ArrayList<>();
        ArrayList<Integer> listNew3 = new ArrayList<>();
        ArrayList<Integer> listNew2 = new ArrayList<>();
        ArrayList<Integer> listNewRest = new ArrayList<>();





        int count = 0;
        while (count < 20){
            listNew.add(Integer.parseInt(reader.readLine()));
            count++;
        }

        int cnt = 0;

        while (cnt < 20){
            if(listNew.get(cnt)%3==0 && listNew.get(cnt)%2==0){
                listNew3.add(listNew.get(cnt));
                listNew2.add(listNew.get(cnt));
            }
             else

                 if (listNew.get(cnt)%3==0){
                listNew3.add(listNew.get(cnt));
            } else if (listNew.get(cnt)%2==0){
                listNew2.add(listNew.get(cnt));
            } else {
                 listNewRest.add(listNew.get(cnt));
            }
            cnt++;
        }


        printList(listNew3);
        printList(listNew2);
        printList(listNewRest);

    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        int cnt2 = 0;
        while (cnt2 < list.size()){
            System.out.println(list.get(cnt2));
            cnt2++;
        }
    }
}
