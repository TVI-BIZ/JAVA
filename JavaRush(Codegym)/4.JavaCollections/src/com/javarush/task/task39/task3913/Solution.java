package com.javarush.task.task39.task3913;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        //LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        LogParser logParser = new LogParser(Paths.get(
                "/Users/vlad3d/JAVA_DEVELOPER/JAVARUSH/JavaRushTasks/" +
                        "4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
//        System.out.println(logParser.getIPsForEvent(Event.DONE_TASK,null,null));

//        Set<String> evSet = logParser.getIPsForEvent(Event.DONE_TASK,null,null);
//        for(String elem:evSet){
//            System.out.println(elem);
//        }
        //PartII
//        System.out.println(logParser.getAllUsers());
//        System.out.println(logParser.getNumberOfUsers(null,null));
       // System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko",null,null));
//        System.out.println(logParser.getUsersForIP("127.0.0.1",null,null));
        //System.out.println(logParser.getDoneTaskUsers(null,null,48));
//         System.out.println(logParser.getDatesForUserAndEvent("Amigo",Event.LOGIN,null,null));
//        System.out.println(logParser.getDatesWhenSomethingFailed(null,null));
        // System.out.println(logParser.getDateWhenUserLoggedFirstTime("Eduard Petrovich Morozko",null,null));
//        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Eduard Petrovich Morozko",null,null));
//        System.out.println(logParser.getDatesWhenUserWroteMessage("Eduard Petrovich Morozko",null,null));
        //Part3
//        System.out.println(logParser.getNumberOfAllEvents(null,null));
//        System.out.println(logParser.getAllEvents(null,null));
//        System.out.println(logParser.getEventsForIP("146.34.15.5",null,null));
//        System.out.println(logParser.getEventsForUser("Amigo",null,null));
//        System.out.println(logParser.getFailedEvents(null,null));
//        System.out.println(logParser.getErrorEvents(null,null));
//        System.out.println(logParser.getNumberOfAttemptToSolveTask(1,null,null));
  //      System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(48,null,null));
//        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null,null));
//        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null,null));
        //Part5;
//        System.out.println(logParser.execute("get ip"));
//        System.out.println(logParser.execute("get user"));
//        System.out.println(logParser.execute("get date"));
//        System.out.println(logParser.execute("get event"));
//        System.out.println(logParser.execute("get status"));
        //Part6
        System.out.println(logParser.execute("get ip for user = \"Amigo\""));


    }
}