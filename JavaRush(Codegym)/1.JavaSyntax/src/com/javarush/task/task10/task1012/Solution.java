package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//import org.apache.commons.lang3.StringUtils;


/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
//        List<Character> alphabet = Arrays.asList(
//                'а','б','в','г','д','е','ё','ж',
//                'з','и','й','к','л','м','н','о',
//                'п','р','с','т','у','ф','х','ц',
//                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        List<Character> alphabet = Arrays.asList('а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');


        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        String bigStr = "";
        int cnt3 = 0;
        while (cnt3 < list.size()){
            bigStr = bigStr + list.get(cnt3);
            cnt3++;
        }
        //System.out.println(bigStr);

        // напишите тут ваш код
        Map<Character,Integer> mapL = new HashMap<>();
        int cnt = 0;
        String testS = "строкатестовая";
        int charcount = 0;

        int cnt2 = 0;

        while (cnt < 33){
            charcount = 0;
            for (int i = 0; i < bigStr.length(); i++) {
                if (bigStr.charAt(i) == alphabet.get(cnt)) {
                    charcount++;
                }
                mapL.put(alphabet.get(cnt),charcount);
            }
            cnt++;
        }


        Map<Character, Integer> sortedMap = new TreeMap<Character, Integer>(mapL);

        Map<Character,Integer> finalMap = new HashMap<>();

        for (Character character : alphabet) {
            System.out.println(character + " " + sortedMap.get(character));
        }




    }
}
