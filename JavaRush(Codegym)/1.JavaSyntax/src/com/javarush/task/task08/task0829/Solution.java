package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,String> familyCountry = new HashMap<>();

        while (true){
            String country = reader.readLine();
            if(country.isEmpty()){
                break;
            }
            String family = reader.readLine();
            familyCountry.put(country,family);
        }

        //System.out.println("adding finished!");
        // Read country
        String country = reader.readLine();

        if(familyCountry.containsKey(country)){
            String family = familyCountry.get(country);
            System.out.println(family);
        }


//
//        List<String> list = new ArrayList<>();
//        while (true) {
//            String family = reader.readLine();
//            if (family.isEmpty()) {
//                break;
//            }
//
//            list.add(family);
//        }

        // Read the house number
//        int houseNumber = Integer.parseInt(reader.readLine());
//
//        if (0 <= houseNumber && houseNumber < list.size()) {
//            String familyName = list.get(houseNumber);
//            System.out.println(familyName);
//        }
        // Read country
//        String country = reader.readLine();
//
//
//
//
//        String familyName = list.get(country);
//        System.out.println(familyName);



    }
}
