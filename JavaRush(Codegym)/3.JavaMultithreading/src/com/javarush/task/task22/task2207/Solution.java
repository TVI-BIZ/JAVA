package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

       FileInputStream fileInputStream = new FileInputStream(fileName);
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
       String resStr = "";
       List<Pair> tempres= new LinkedList<>();

       while (bufferedReader.ready()){
           String linew = bufferedReader.readLine();
           resStr += linew+" ";
       }

       String[] resStrArr = resStr.split(" ");
       for(int i =0; i < resStrArr.length; i++){
           for(int j = 0; j<resStrArr.length;j++){
               if((resStrArr[i].equals((new StringBuilder(resStrArr[j]).reverse()).toString()))
                       && (resStrArr[i] != resStrArr[j])){
                   Pair pairStr = new Pair();
                   pairStr.first = resStrArr[i];
                   pairStr.second = resStrArr[j];
                   tempres.add(pairStr);
               }
           }
       }
       int cnt = 0;
       result.add(tempres.get(0));


       for(int i=0; i<tempres.size();i++){
           cnt = 0;
           for(int j=0; j<result.size();j++){
               String f1 = tempres.get(i).toString();
               String f2 = result.get(j).toString();
//               System.out.println("F1 "+ f1 + "F2 " +f2);
//               System.out.println(f1.equals(f2));
               if(f1.equals(f2)){
                   cnt ++;
               }
           }
           if(cnt == 0){
               result.add(tempres.get(i));
           }
       }

        for(Pair elem: result){
            System.out.println(elem);
        }
//        System.out.println(result.size());




    }

    public static class Pair {
        String first;
        String second;

        public Pair(){


        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
