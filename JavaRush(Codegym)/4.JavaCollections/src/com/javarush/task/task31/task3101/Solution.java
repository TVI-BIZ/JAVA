package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println(args.length);
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File resultFile = new File(resultFileAbsolutePath);
        File newResultFile = new File(resultFile.getParent()+"/" + "allFilesContent.txt");

        FileUtils.renameFile(resultFile,newResultFile);

        FileOutputStream fileOutputStream2 = new FileOutputStream(newResultFile);
        PrintWriter writer2 = new PrintWriter(fileOutputStream2);

        try {
            Path filePath = Paths.get(path);
            List<Path> filePath2 = Files.walk(filePath).filter(s -> s.toString().endsWith(".txt")).map(Path::toAbsolutePath).sorted().collect(Collectors.toList());
            List<Path> filePath3 = new LinkedList<>();
            List<String> stringPath = new LinkedList<>();
            List<String> finalStringPath = new LinkedList<>();

            for (Path elem : filePath2) {
                File tempF = new File(elem.toString());
                if (tempF.length() <= 50) {
                    filePath3.add(elem);
                    stringPath.add(tempF.getName() + tempF.getParent() + "/");
                }
            }

            Collections.sort(stringPath);

            for (String elem : stringPath) {
                finalStringPath.add(elem.substring(elem.indexOf("/")) + elem.split("/")[0]);
            }

            List<String> fileContentList = new LinkedList<>();


            for (String elem : finalStringPath) {
                FileInputStream fileInputStream = new FileInputStream(elem);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    fileContentList.add(line);
                }
                fileInputStream.close();
                bufferedReader.close();
            }


            for (String elem : fileContentList) {
                writer2.println(elem);
            }
        } finally {
        fileOutputStream2.close();
        writer2.close();
        }
    }

}
