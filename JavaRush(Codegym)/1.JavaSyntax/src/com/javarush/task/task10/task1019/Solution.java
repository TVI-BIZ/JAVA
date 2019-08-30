package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> newMap = new HashMap<>();

        while (true){
            int id;
            try{
                id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                if(name.isEmpty()){
                    newMap.put("",id);
                    break;
                }
                newMap.put(name,id);
            } catch (Exception e){
                break;
            }






           // boolean flag = false;


//            for(Map.Entry<Integer,String> pair: newMap.entrySet()){
//                String val = pair.getValue();
//                if (name.equals(val)){
//                    flag = true;
//                }
//            }
//
//            if (flag == false){
//                newMap.put(id,name);
//                System.out.println(id + "id");
//                System.out.println(name + "name");
//            }
        }
        for(Map.Entry<String,Integer> pair: newMap.entrySet()){
            String key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(value + " " + key );
        }




//        int first;// = Integer.parseInt(reader.readLine())
//        String name;// = reader.readLine();
//        do{
//            first = Integer.parseInt(reader.readLine());
//            name = reader.readLine();
//            newMap.put(first,name);
//        } while (!reader.readLine().isEmpty());
//        do{
//            name = reader.readLine();
//            System.out.println(name);
//        } while (!reader.readLine().isEmpty());



      //  while (name.isEmpty() ){
//            int id = Integer.parseInt(reader.readLine());
//            String name = reader.readLine();

           // newMap.put(id,name);
            //System.out.println("Good!");
//            if(reader.readLine().length() != 0){
//                System.out.println("good");
//            } else {
//                break;
//            }


      //  }


//        int id = Integer.parseInt(reader.readLine());
//        String name = reader.readLine();
//
//        newMap.put(id,name);

//        for(Map.Entry<Integer,String> pair: newMap.entrySet()){
//            Integer key = pair.getKey();
//            String value = pair.getValue();
//            System.out.println(key + " " + value);
//        }

        //System.out.println("Id=" + id + " Name=" + name);
    }
}
