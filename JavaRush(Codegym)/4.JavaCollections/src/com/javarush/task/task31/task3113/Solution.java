package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();

        Path pathFile = Paths.get(filePath).toAbsolutePath();


        if(!Files.isDirectory(pathFile)){
            System.out.println(filePath + " - не папка");
            return;
        }

        Path filePath2 = Paths.get(filePath);
        //List<Path> filePath2 =  Files.walk(filePath).filter(s -> s.toString().endsWith("")).map(Path::toAbsolutePath).sorted().collect(Collectors.toList());
        long filesPathList = Files.walk(filePath2).filter(Files::isRegularFile).count();
        long foldersPathList = Files.walk(filePath2).filter(Files::isDirectory).count();




            final AtomicLong size = new AtomicLong(0L);

            Files.walkFileTree(Paths.get(filePath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    size.addAndGet(attrs.size());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    //just skip
                    return FileVisitResult.CONTINUE;
                }
            });









        System.out.println("Всего папок - " + (foldersPathList-1));
        System.out.println("Всего файлов - " + filesPathList);
        System.out.println("Общий размер - " + size.get());
    }
}
