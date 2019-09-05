package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(file1);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            allLines.add(line);
        }
        bufferedReader.close();
        for(String elem: allLines){
            System.out.println(elem);
        }




        FileInputStream fileInputStream2 = new FileInputStream(file2);
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream2));

        while (bufferedReader2.ready()){
            String line = bufferedReader2.readLine();
            forRemoveLines.add(line);
        }
        bufferedReader2.close();

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e){
            System.out.println(e);
        }
        fileInputStream.close();
        fileInputStream2.close();


    }

    public void joinData() throws CorruptedDataException {
        int lineCount = 0;
            for(String elem2:forRemoveLines){
                if(allLines.contains(elem2)){
                    lineCount++;
                }
            }

        if(lineCount == forRemoveLines.size()){
                for(String elem2:forRemoveLines){
                   if(allLines.contains(elem2)){
                       allLines.remove(elem2);
                   }
                }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }







    }
}
