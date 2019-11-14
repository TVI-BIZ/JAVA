package com.javarush.task.task39.task3913;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        LogParser logParser = new LogParser(Paths.get(
                "/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/JavaRushTasks/" +
                        "4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
    }
}