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
        System.out.println("***********SMALL************");
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));

        //Part6
        System.out.println("***********MEDIUM************");
       // System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\""));
        System.out.println(logParser.execute("get ip for user = \"Amigo\""));
        System.out.println(logParser.execute("get ip for date = \"12.12.2013 21:56:30\""));
        System.out.println(logParser.execute("get ip for event = \"LOGIN\""));

        System.out.println(logParser.execute("get user for ip = \"146.34.15.5\""));
//        System.out.println(logParser.execute("get ip for date = \"13.09.2013 5:04:50\""));
        //System.out.println(logParser.execute("get user for event = \"DONE_TASK\""));
//        System.out.println(logParser.execute("get date for event = \"SOLVE_TASK\""));
//        System.out.println(logParser.execute("get status for event = \"SOLVE_TASK\""));
//        System.out.println(logParser.execute("get event for date = \"30.08.2012 16:08:40\""));
//        System.out.println(logParser.execute("get event for date = \"03.01.2014 03:45:23\""));
//        System.out.println(logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
//        System.out.println(logParser.execute("get event for status = \"ERROR\""));
//        System.out.println(logParser.execute("get date for user = \"Eduard Petrovich Morozko\""));
//        System.out.println(logParser.execute("get date for user = \"Amigo\""));
//        System.out.println(logParser.execute("get user for event=\"SOLVE_TASK\""));
//        System.out.println(logParser.execute("get user for event=\"SOLVE_TASK\""));
//        System.out.println(logParser.execute("get user for event=\"SOLVE_TASK\""));
        //Part7
        System.out.println("***********BIG************");
//        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 10:11:11\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get ip for date = \"12.12.2013 21:56:30\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get ip for event = \"SOLVE_TASK\" and date between \"03.01.2014 03:45:22\" and \"29.2.2028 5:4:7\"."));
//        System.out.println(logParser.execute("get ip for status = \"FAILED\" and date between \"30.08.2012 16:08:13\" and \"29.2.2028 5:4:7\"."));
//
//        System.out.println(logParser.execute("get user for ip = \"127.0.0.1\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get user for date = \"12.12.2013 21:56:30\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get user for event = \"WRITE_MESSAGE\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get user for status = \"OK\" and date between \"30.08.2012 16:08:13\" and \"21.10.2021 19:45:25\"."));

        System.out.println(logParser.execute("get date for ip = \"127.0.0.1\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
        System.out.println(logParser.execute("get date for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
        System.out.println(logParser.execute("get date for event = \"WRITE_MESSAGE\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
        System.out.println(logParser.execute("get date for status = \"OK\" and date between \"30.08.2012 16:08:13\" and \"21.10.2021 19:45:25\"."));

//        System.out.println(logParser.execute("get event for ip = \"127.0.0.1\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get event for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get event for date = \"12.12.2013 21:56:30\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get event for status = \"OK\" and date between \"30.08.2012 16:08:13\" and \"21.10.2021 19:45:25\"."));
//
//        System.out.println(logParser.execute("get status for ip = \"127.0.0.1\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get status for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get status for date = \"12.12.2013 21:56:30\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
//        System.out.println(logParser.execute("get status for event = \"WRITE_MESSAGE\" and date between \"30.08.2012 16:08:13\" and \"21.10.2021 19:45:25\"."));


    }
}