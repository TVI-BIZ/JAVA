package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       // try{
            int a = Integer.parseInt(reader.readLine());
            if(a <= 0) throw new Exception();
            int b = Integer.parseInt(reader.readLine());
            if(b <= 0) throw new Exception();

//            if ((a < 0) || (b < 0)){
//                throw new Exception ("Not positive!");
//            }

            ArrayList<Integer> listA = new ArrayList<>();
            ArrayList<Integer> listB = new ArrayList<>();

            for(int i = 1; i < b+1; i++){
                if(b%i == 0){
                    listA.add(i);
                    for(int j =1; j < a+1; j++){
                        if(a%j == 0){
                            listB.add(j);
                        }
                    }
                }
            }

            if(listA.size() >= listB.size()){
                for(Integer elem: listB){
                    listA.add(elem);
                }


                LinkedHashSet<Integer> hashSetA = new LinkedHashSet<>(listA);
                ArrayList<Integer> listWithoutDuplicatesA = new ArrayList<>(hashSetA);

                //System.out.println("liatA");
                Collections.sort(listWithoutDuplicatesA);
                Collections.reverse(listWithoutDuplicatesA);
                //System.out.println(listWithoutDuplicatesA);

                for(Integer elem: listWithoutDuplicatesA){
                    if((a % elem ==0) && (b%elem == 0)){
                        System.out.println(elem);
                        break;
                    }
                }


            } else {
                for(Integer elem: listA){
                    listB.add(elem);
                }

                LinkedHashSet<Integer> hashSetB = new LinkedHashSet<>(listB);
                ArrayList<Integer> listWithoutDuplicatesB = new ArrayList<>(hashSetB);


                Collections.sort(listWithoutDuplicatesB);
                Collections.reverse(listWithoutDuplicatesB);


                for(Integer elem: listWithoutDuplicatesB){
                    if((a % elem ==0) && (b%elem == 0)){
                        System.out.println(elem);
                        break;
                    }
                }

            }

//        } catch (Exception e){
//            System.out.println(e);
//        }


    }
}
