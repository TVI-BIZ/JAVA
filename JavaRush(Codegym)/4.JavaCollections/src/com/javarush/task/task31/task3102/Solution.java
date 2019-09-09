package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Path filePath = Paths.get(root);
        //List<Path> filePath2 =  Files.walk(filePath).filter(s -> s.toString().endsWith("")).map(Path::toAbsolutePath).sorted().collect(Collectors.toList());
        List<Path> filePath2 = Files.walk(filePath).filter(Files::isRegularFile).map(Path::toAbsolutePath).sorted().collect(Collectors.toList());


        List<String> pathString = new LinkedList<>();

        for(Path elem:filePath2){
            System.out.println(elem);
            pathString.add(elem.toString());
        }



        return pathString;

    }

    public static void main(String[] args) throws IOException {
        getFileTree("/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/files/");
    }
}
