package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> mixP = new LinkedHashMap<>();
        mixP.put("name","Ivanov");
        mixP.put("country","Ukraine");
        mixP.put("city","Kiev");
        mixP.put("age",null);

        System.out.println(getQuery(mixP));
    }
    public static String getQuery(Map<String, String> params) {
        String resStr = "";
        for(Map.Entry<String,String> elem:params.entrySet()){
            String key = elem.getKey();
            String value = elem.getValue();
            if(value != null){
                resStr += key + " = " + "'"+value+"'" + " and ";
            }
        }
        int lastCh = resStr.lastIndexOf("'");
        int lastEnd = resStr.length();
        StringBuilder sb = new StringBuilder(resStr);
        sb.replace(lastCh+1,lastEnd+1,"");

        resStr = sb.toString();


        return resStr;
    }
}
