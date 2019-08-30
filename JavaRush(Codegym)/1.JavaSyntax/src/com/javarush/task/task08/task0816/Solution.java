package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне1", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("APRIL 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("MARCH 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("MAY 1 2012"));

        return map;

    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код


//        String seasons[] = {
//                "Winter", "Winter",
//                "Spring", "Spring", "Spring",
//                "Summer", "Summer", "Summer",
//                "Fall", "Fall", "Fall",
//                "Winter"
//        };
//        String getSeason( Date date ) {
//            return seasons[ date.getMonth() ];
//        }

        Map<String, Date> mapSum = new HashMap<>();


        for(Map.Entry<String,Date> elem: map.entrySet()){
            Date data = elem.getValue();
            String key = elem.getKey();
            //System.out.println(data.getMonth()+1);
            if(data.getMonth() + 1 == 6 || data.getMonth() + 1  == 7 || data.getMonth() + 1 == 8){
                //System.out.println("Summer");
                mapSum.put(key,data);
            }
        }
        for(Map.Entry<String,Date> elemSum: mapSum.entrySet()){
            String keySum = elemSum.getKey();
            Date dataSum = elemSum.getValue();
            map.remove(keySum);
//                System.out.println(dataSum);
//                System.out.println(keySum);
        }
        //System.out.println(map.size());

    }

    public static void main(String[] args) {

//        try {
//                Map<String, Date> map1 = createMap();
//                removeAllSummerPeople(map1);
            //System.out.println(map1.size());

//            for(Map.Entry<String, Date> elem: map1.entrySet()){
//                System.out.println(elem);
//            }
//                System.out.println(elem);
//                Date data = elem.getValue();
//                String key = elem.getKey();
//                System.out.println(data.getMonth()+1);
//                if(data.getMonth() +1 == 6 || data.getMonth() + 1 == 7 || data.getMonth() + 1 == 8){
//                    map1.remove(key);
//                }

            //}
//        } catch(Exception e ){
//            System.out.println(e);
//        }

//        for(Map.Entry<String, Date> elem: map1)
    }
}
