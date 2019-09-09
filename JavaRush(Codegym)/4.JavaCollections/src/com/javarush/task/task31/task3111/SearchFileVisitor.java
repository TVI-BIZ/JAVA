package com.javarush.task.task31.task3111;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    Map<Integer,Integer> checked = new HashMap<Integer,Integer>();
    boolean[] conditions = new boolean[4];



    private List<Path> foundFiles = new LinkedList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        checked.put(0,1);
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        checked.put(1,1);
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        checked.put(2,1);
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        checked.put(3,1);
        this.maxSize = maxSize;
    }



    List<Boolean> boolList = new LinkedList<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String fileString = file.toString();
        String fileContent = new String(content);

        if(partOfName != null) {
            conditions[0] = fileString.contains(partOfName);
        }
        if(partOfContent != null){
            conditions[1] = fileContent.contains(partOfContent);
        }
        conditions[2] = content.length > minSize;
        conditions[3] = content.length < maxSize;


        for(Map.Entry<Integer,Integer> elem: checked.entrySet()){
            Integer key = elem.getKey();
            Integer value = elem.getValue();
            if(value == 1){
                boolList.add(conditions[key]);
            }
        }
        int count = 0;
        for(Boolean elem: boolList){
           // System.out.println(elem);
            if(elem==true){
                count++;
            }
        }
        if(count == boolList.size()){
            foundFiles.add(file);
        }

        boolList.clear();

        return super.visitFile(file, attrs);
    }
}
