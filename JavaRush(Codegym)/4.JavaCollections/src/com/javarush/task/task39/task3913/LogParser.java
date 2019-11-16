package com.javarush.task.task39.task3913;
import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.TreeSet;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {


    private Path logDir;

    //*********Constructor
    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    //My Helper Function Get List of String From File
    //*********************************************************
    public List<String> getStringListFromFile(Path path){
        File[] listOfFiles = new File(path.toString()).listFiles();
        BufferedReader reader;
        List<String> fileDataArray = new ArrayList<>();

        //absolute path to file

        for(File elem:listOfFiles){
            if(elem.getAbsolutePath().endsWith(".log")){
                try{
                    reader = new BufferedReader(new FileReader(elem.getAbsolutePath()));
                    String textline = reader.readLine();
                    while (textline !=null){
                        fileDataArray.add(textline);
                        textline = reader.readLine();
                    }
                    reader.close();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        return fileDataArray;
    }
    //II attempt getMapFromData!
    public Map<Date,String> getMapFromData2(List<String> fileDataArray) {
        Map<Date,String> ipMap = new HashMap<>();
        String data_pattern1 = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(data_pattern1);
        for(String elem:fileDataArray){
            String[] stringArr = elem.split("\t");
            try{
                ipMap.put(simpleDateFormat.parse(stringArr[2]),stringArr[0]);
            } catch (Exception e){
            }
        }
        return ipMap;
    }
    //*********Helper_Boolean_return is our date in range
    public boolean isDateInRange(Date ourDate,Date after, Date before){
        if((after==null)&&(before==null)){
            return true;
        } else if(after==null){
            if(before.compareTo(ourDate) >= 0){
                return true;
            }
        } else if(before==null){
            if(after.compareTo(ourDate) <= 0){
                return true;
            }
        } else{
            if((after == null || !ourDate.before(after)) && (before == null || !ourDate.after(before))){
                return true;
            }
        }
        return false;
    }
    //*** For 7 Special
    public boolean isDateInRange7(Date ourDate,Date after, Date before){
        if((after==null)&&(before==null)){
            return true;
        } else if(after==null){
            if(before.compareTo(ourDate) > 0){
                return true;
            }
        } else if(before==null){
            if(after.compareTo(ourDate) < 0){
                return true;
            }
        } else{
            if((after == null || !ourDate.before(after)) && (before == null || !ourDate.after(before))){
                return true;
            }
        }
        return false;
    }


    //*********Helper_add_data_to set
    public void addDataToSet(Set<String> hashset,String value){
        hashset.add(value);
    }
    public void addDataToSet2(Set<Date> hashset,Date value){
        hashset.add(value);
    }
    public void addDataToSet3(Set<Event> hashset,Event value){
        hashset.add(value);
    }


    //***********Helper_parser
    public String parseDataFromString(int elemNum,String dataString){
        String[] stringArr = dataString.split("\t");
        return stringArr[elemNum];
    }
    //*************Helper_EventParser


    //*********Helper_getDateFromText
    public Date getDateFromText(String dataString){
        Date dateFromList = null;
        String data_pattern1 = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(data_pattern1);
        try{
            dateFromList = simpleDateFormat.parse(parseDataFromString(2,dataString));
        } catch (Exception e){
            System.out.println(e);
        }
        return dateFromList;
    }

    //***********IP_____
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        boolean isInRange = false;
        for(String elem:fileDataArray) {
                dateFromList = getDateFromText(elem);
                isInRange = isDateInRange(dateFromList,after,before);
                if(isInRange){
                    addDataToSet(ipUserSet,parseDataFromString(0,elem));
                }
        }
        return ipUserSet.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        boolean isInRange = false;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange){
                addDataToSet(ipUserSet,parseDataFromString(0,elem));
            }
        }
        return ipUserSet;
    }
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        boolean isInRange = false;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange && parseDataFromString(1,elem).equals(user)){
                addDataToSet(ipUserSet,parseDataFromString(0,elem));
            }
        }
        return ipUserSet;
    }



    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        boolean isInRange = false;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange && eventArray[0].equals(event.toString())){
                addDataToSet(ipUserSet,parseDataFromString(0,elem));
            }

        }
        return ipUserSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        boolean isInRange = false;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange && parseDataFromString(4,elem).equals(status.toString())){
                addDataToSet(ipUserSet,parseDataFromString(0,elem));
            }
        }
        return ipUserSet;
    }
    //******************PART2
    @Override
    public Set<String> getAllUsers() {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            addDataToSet(userSet,parseDataFromString(1,elem));
        }
        return userSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> userSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange){
                addDataToSet(userSet,parseDataFromString(1,elem));
            }
        }
        return userSet.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> userSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange&&parseDataFromString(1,elem).equals(user)&&isInRange){
                addDataToSet(userSet,parseDataFromString(3,elem));
            }
        }
        return userSet.size();
    }
    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            //boolean isInRange = insideDate(dateFromList,after,before);
            if(isInRange&&parseDataFromString(0,elem).equals(ip)){
                addDataToSet(userSet,parseDataFromString(1,elem));
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange&&parseDataFromString(3,elem).equals(Event.LOGIN.toString())){
                addDataToSet(userSet,parseDataFromString(1,elem));
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange&&parseDataFromString(3,elem).equals(Event.DOWNLOAD_PLUGIN.toString())){
                addDataToSet(userSet,parseDataFromString(1,elem));
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange&&parseDataFromString(3,elem).equals(Event.WRITE_MESSAGE.toString())){
                addDataToSet(userSet,parseDataFromString(1,elem));
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange&&eventArray[0].equals(Event.SOLVE_TASK.toString())){
                addDataToSet(userSet,parseDataFromString(1,elem));
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(eventArray.length == 2){
                if(isInRange&&eventArray[0].equals(Event.SOLVE_TASK.toString())&&Integer.valueOf(eventArray[1])==task){
                    addDataToSet(userSet,parseDataFromString(1,elem));
                }
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange&&eventArray[0].equals(Event.DONE_TASK.toString())){
                addDataToSet(userSet,parseDataFromString(1,elem));
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> userSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(eventArray.length==2){
                if(isInRange&&eventArray[0].equals(Event.DONE_TASK.toString())&&Integer.valueOf(eventArray[1])==task){
                    addDataToSet(userSet,parseDataFromString(1,elem));
                }
            }
        }
        return userSet;
    }
    //******************PART3
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
                if(isInRange
                        && eventArray[0].equals(event.toString())
                        && parseDataFromString(1,elem).equals(user)){
                    addDataToSet2(dateSet,dateFromList);
                }
        }
        return dateSet;
    }
    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange
                    &&parseDataFromString(4,elem).equals("FAILED")){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange
                    &&parseDataFromString(4,elem).equals("ERROR")){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        return dateSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        TreeSet<Date> dateSet = new TreeSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange
                    &&parseDataFromString(3,elem).equals(Event.LOGIN.toString())
                    &&parseDataFromString(1,elem).equals(user)){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        if(dateSet.size()>0){
            return dateSet.first();
        } else {
            return null;
        }
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        TreeSet<Date> dateSet = new TreeSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] taskDate = parseDataFromString(3,elem).split(" ");
            if(taskDate.length ==2){
                if(isInRange
                        &&parseDataFromString(1,elem).equals(user)
                        &&Integer.valueOf(taskDate[1]) == task
                        &&taskDate[0].equals(Event.SOLVE_TASK.toString())) {
                    addDataToSet2(dateSet,dateFromList);
                }
            }
        }
        if(dateSet.size()>0){
            return dateSet.first();
        } else {
            return null;
        }
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        TreeSet<Date> dateSet = new TreeSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] taskDate = parseDataFromString(3,elem).split(" ");
            if(taskDate.length ==2){
                if(isInRange
                        &&parseDataFromString(1,elem).equals(user)
                        &&Integer.valueOf(taskDate[1]) == task
                        &&taskDate[0].equals(Event.DONE_TASK.toString())) {
                    addDataToSet2(dateSet,dateFromList);
                }
            }
        }
        if(dateSet.size()>0){
            return dateSet.first();
        } else {
            return null;
        }
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange
                    &&parseDataFromString(1,elem).equals(user)
                    &&parseDataFromString(3,elem).equals(Event.WRITE_MESSAGE.toString())){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(isInRange
                    &&parseDataFromString(1,elem).equals(user)
                    &&parseDataFromString(3,elem).equals(Event.DOWNLOAD_PLUGIN.toString())){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        return dateSet;
    }
    //*******PART4
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange){
                addDataToSet3(eventSet,Event.valueOf(eventArray[0]));
            }
        }
        return eventSet.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange){
                addDataToSet3(eventSet,Event.valueOf(eventArray[0]));
            }
        }
        return eventSet;
    }


    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange&&parseDataFromString(0,elem).equals(ip)){
                addDataToSet3(eventSet,Event.valueOf(eventArray[0]));
            }
        }
        return eventSet;
    }


    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange
                    &&parseDataFromString(1,elem).equals(user)){
                addDataToSet3(eventSet,Event.valueOf(eventArray[0]));
            }
        }
        return eventSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange
                    &&parseDataFromString(4,elem).equals("FAILED")){
                addDataToSet3(eventSet,Event.valueOf(eventArray[0]));
            }
        }
        return eventSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(isInRange
                    &&parseDataFromString(4,elem).equals("ERROR")){
                addDataToSet3(eventSet,Event.valueOf(eventArray[0]));
            }
        }
        return eventSet;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        int counter = 0;
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(eventArray.length==2){
                if(isInRange
                        &&eventArray[0].equals(Event.SOLVE_TASK.toString())
                        &&Integer.valueOf(eventArray[1])==task
                ){
                   counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        int counter = 0;
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(eventArray.length==2){
                if(isInRange
                        &&eventArray[0].equals(Event.DONE_TASK.toString())
                        &&Integer.valueOf(eventArray[1])==task
                ){
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Map<Integer,Integer> solvedTaskMap = new HashMap<>();
        Set<Integer> taskSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(eventArray.length==2){
                if(isInRange
                        &&eventArray[0].equals(Event.SOLVE_TASK.toString())){
                       taskSet.add(Integer.valueOf(eventArray[1]));
                       if(solvedTaskMap.containsKey(Integer.valueOf(eventArray[1]))){
                            int newVal = solvedTaskMap.get(Integer.valueOf(eventArray[1])) +1;
                            solvedTaskMap.put(Integer.valueOf(eventArray[1]),newVal);
                       } else {
                           solvedTaskMap.put(Integer.valueOf(eventArray[1]),1);
                       }
                }
            }
        }
        return solvedTaskMap;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Map<Integer,Integer> solvedTaskMap = new HashMap<>();
        Set<Integer> taskSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(eventArray.length==2){
                if(isInRange
                        &&eventArray[0].equals(Event.DONE_TASK.toString())){
                    taskSet.add(Integer.valueOf(eventArray[1]));
                    if(solvedTaskMap.containsKey(Integer.valueOf(eventArray[1]))){
                        int newVal = solvedTaskMap.get(Integer.valueOf(eventArray[1])) +1;
                        solvedTaskMap.put(Integer.valueOf(eventArray[1]),newVal);
                    } else {
                        solvedTaskMap.put(Integer.valueOf(eventArray[1]),1);
                    }
                }
            }
        }
        return solvedTaskMap;
    }
    //***********Helper GET All dates
    public Set<Date> getAllDates(Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for (String elem : fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList, after, before);
            if (isInRange) {
                addDataToSet2(dateSet, dateFromList);
            }
        }
        return dateSet;
    }
    //************Helper GET All Status
    public Set<Status> getAllStatus(Date after, Date before) {
        Set<Status> statusSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for (String elem : fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList, after, before);
            if (isInRange) {
                statusSet.add(Status.valueOf(parseDataFromString(4,elem)));
            }
        }
        return statusSet;
    }
    //******Helper Split String

    public String getSplitedEq(String bigString){
        String[] queryArray = bigString.split("=");
        return queryArray[1].substring(2,queryArray[1].length()-1);
    }
    //*******Helper Regex
    public String getSplited(String bigString){
        String[] queryArray = bigString.split(" ");
        return queryArray[5].replaceAll("^\"|\"$", "");
    }

    public String getCleanDateValue1(String bigString){
        return bigString.substring(2,bigString.length()-1);
    }
    public String getCleanDateAfter(String bigString){
        return bigString.replaceAll("^\"|\"$", "");
    }
    public String getCleanDateBefore(String bigString){
        return bigString.substring(1,bigString.length()-2);
    }
    public String getCleanDateValue1Date(String bigString){
        return bigString.substring(2,bigString.length()-1);
    }





    //***Helper Get Date From String
    public Date getSimpleDateFromText(String dataString){
        Date dateFromList = null;
        String data_pattern1 = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(data_pattern1);
        try{
            dateFromList = simpleDateFormat.parse(dataString);
        } catch (Exception e){
            System.out.println(e);
        }
        return dateFromList;
    }
    //****Helper UniqueIP for Date
    public Set<String> getUniqueIPsExactDate(Date exactDate) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            if(dateFromList.equals(exactDate)){
                addDataToSet(ipUserSet,parseDataFromString(0,elem));
            }
        }
        return ipUserSet;
    }
    //****Helper UniqueUser for Date
    public Set<String> getUniqueUsersExactDate(Date exactDate) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> userSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            if(dateFromList.equals(exactDate)){
                addDataToSet(userSet,parseDataFromString(1,elem));
            }
        }
        return userSet;
    }
    //**Helper UserForExactEvent
    public Set<String> getUniqueUsersForEvent(Event event) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> userSet = new HashSet<>();
        for (String elem : fileDataArray) {
            String[] eventArr = parseDataFromString(3, elem).split(" ");
            if (event.equals(Event.valueOf(eventArr[0]))) {
                addDataToSet(userSet, parseDataFromString(1, elem));
            }
        }
        return userSet;
    }

    public Set<String> getUniqueUsersForStatus(Status status) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> userSet = new HashSet<>();
        for (String elem : fileDataArray) {
            if (status.equals(Status.valueOf(parseDataFromString(4, elem)))) {
                addDataToSet(userSet, parseDataFromString(1, elem));
            }
        }
        return userSet;
    }
    //******************* Date Helpers
    public Set<Date> getDatesForIP(String ip) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            if(parseDataFromString(0,elem).equals(ip)){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        return dateSet;
    }
    public Set<Date> getDatesForUser(String user) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            if(parseDataFromString(1,elem).equals(user)){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        return dateSet;
    }
    public Set<Date> getDatesForEvent(Event event) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            String[] eventArr = parseDataFromString(3, elem).split(" ");
            if(Event.valueOf(eventArr[0]).equals(event)){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        return dateSet;
    }
    public Set<Date> getDatesForStatus(Status status) {
        Set<Date> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            if(Status.valueOf(parseDataFromString(4,elem)).equals(status)){
                addDataToSet2(dateSet,dateFromList);
            }
        }
        return dateSet;
    }
    //*********Event Helpers
    public Set<Event> getUniqueEventsExactDate(Date exactDate) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> userSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            String[] eventArr = parseDataFromString(3,elem).split(" ");
            if(dateFromList.equals(exactDate)){
                //addDataToSet(userSet, eventArr[0]);
                userSet.add(Event.valueOf(eventArr[0]));
            }
        }
        return userSet;
    }
    public Set<Event> getUniqueEventsForStatus(Status status) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Event> eventSet = new HashSet<>();
        for(String elem:fileDataArray) {
            String[] eventArr = parseDataFromString(3,elem).split(" ");
            if(status.equals(Status.valueOf(parseDataFromString(4,elem)))){
                eventSet.add(Event.valueOf(eventArr[0]));
            }
        }
        return eventSet;
    }
    //*******StatusHelpers


    //*********PART5
    public Set<Status> getStatusForIP(String ip) {
        Set<Status> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            if(parseDataFromString(0,elem).equals(ip)){
               dateSet.add(Status.valueOf(parseDataFromString(4,elem)));
            }
        }
        return dateSet;
    }
    public Set<Status> getDatesStatusUser(String user) {
        Set<Status> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            if(parseDataFromString(1,elem).equals(user)){
                dateSet.add(Status.valueOf(parseDataFromString(4,elem)));
            }
        }
        return dateSet;
    }
    public Set<Status> getUniqueStatusExactDate(Date exactDate) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<Status> userSet = new HashSet<>();
        for(String elem:fileDataArray) {
            Date dateFromList = getDateFromText(elem);
            if(dateFromList.equals(exactDate)){
               userSet.add(Status.valueOf(parseDataFromString(4,elem)));
            }
        }
        return userSet;
    }
    public Set<Status> getStatusForEvent(Event event) {
        Set<Status> dateSet = new HashSet<>();
        List<String> fileDataArray = getStringListFromFile(logDir);
        for(String elem:fileDataArray) {
            String[] eventArray = parseDataFromString(3,elem).split(" ");
            if(Event.valueOf(eventArray[0]).equals(event)){
               dateSet.add(Status.valueOf(parseDataFromString(4,elem)));
            }
        }
        return dateSet;
    }
    public boolean insideDate(Date ourDate,Date after,Date before){
        if(((ourDate.getTime()<before.getTime())&&(ourDate.getTime()>after.getTime()))){
            return true;
        }else{
            return false;
        }
    }

    //********* IP BIG HELPERS
    public Set<String> getBIGUniqueIPsExactDate(Date exactDate,Date after,Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange7(dateFromList,after,before);
            if(dateFromList.equals(exactDate)&&isInRange){
                addDataToSet(ipUserSet,parseDataFromString(0,elem));
            }
        }
        return ipUserSet;
    }
    public Set<String> getBIGUniqueIPsExactEvent(Event event,Date after,Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            boolean isInRange = insideDate(dateFromList,after,before);
            //boolean isInRange = isDateInRange7(dateFromList,after,before);
            //boolean isInRange = isDateInRange(dateFromList,after,before);
            String[] eventsArr = parseDataFromString(3,elem).split(" ");
//            if(Event.valueOf(eventsArr[0]).equals(event)&&isInRange){
//                addDataToSet(ipUserSet,parseDataFromString(0,elem));
//            }

            if((event.equals(Event.valueOf(eventsArr[0])))&&isInRange){
                addDataToSet(ipUserSet,parseDataFromString(0,elem));
            }

        }
        return ipUserSet;
    }
    public Set<String> getBIGUniqueIPsExactStatus(Status status,Date after,Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            boolean isInRange = insideDate(dateFromList,after,before);
            //boolean isInRange = isDateInRange7(dateFromList,after,before);
            if(Status.valueOf(parseDataFromString(4,elem)).equals(status)&&isInRange){
                addDataToSet(ipUserSet,parseDataFromString(0,elem));
            }
        }
        return ipUserSet;
    }


    //********* USER BIG HELPERS
    public Set<String> getBIGUniqueUsersExactDate(Date exactDate,Date after,Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(dateFromList.equals(exactDate)&&isInRange){
                addDataToSet(ipUserSet,parseDataFromString(1,elem));
            }
        }
        return ipUserSet;
    }

    public Set<String> getBIGUniqueUsersExactEvent(Event event,Date after,Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            String[] eventArr = parseDataFromString(3,elem).split(" ");
            boolean isInRange = isDateInRange(dateFromList,after,before);
            if(event.equals(Event.valueOf(eventArr[0]))&&isInRange){
                addDataToSet(ipUserSet,parseDataFromString(1,elem));
            }
        }
        return ipUserSet;
    }
    public Set<String> getBIGUniqueUsersExactStatus(Status status,Date after,Date before) {
        List<String> fileDataArray = getStringListFromFile(logDir);
        Set<String> ipUserSet = new HashSet<>();
        Date dateFromList = null;
        for(String elem:fileDataArray) {
            dateFromList = getDateFromText(elem);
            boolean isInRange = isDateInRange(dateFromList,after,before);
            System.out.println(status.equals(Status.valueOf(parseDataFromString(4,elem))));
            if(status.equals(Status.valueOf(parseDataFromString(4,elem)))&&isInRange){
                addDataToSet(ipUserSet,parseDataFromString(1,elem));
            }
        }
        return ipUserSet;
    }




    @Override
    public Set<Object> execute(String query) {

        if(query.equals("get ip")){
            return new HashSet<>(getUniqueIPs(null, null));
        } else if (query.equals("get user")){
            return new HashSet<>(getAllUsers());
        }else if (query.equals("get date")){
            return new HashSet<>(getAllDates(null,null));
        }else if (query.equals("get event")){
            return new HashSet<>(getAllEvents(null, null));
        }else if (query.equals("get status")){
            return new HashSet<>(getAllStatus(null,null));
        } else{

            //get field1 for field2 = "value1"
            String[] queryArray = query.split(" ");
            String[] queryArrayEq = query.split("=");
            String[] dividedSpace = queryArrayEq[0].split(" ");
            //field1 - dividedSpace[1]
            //field2 - dividedSpace[3]
            String[] wordsDivided = queryArrayEq[1].split(" and date between ");
            String[] wordsDividedAnd={};
            // value1 - wordsDivided[0]
            if(queryArrayEq[1].contains(" and ")){
                wordsDividedAnd = wordsDivided[1].split(" and ");
            }

            // after - wordsDividedAnd[0]
            //before - wordsDividedAnd[1]


            //if(queryArray.length<7){
                if(queryArray[1].equals("ip") &&queryArray[3].equals("user")){
                    if(queryArrayEq[1].contains(" and date between ")){
                        return new HashSet<>(getIPsForUser(getCleanDateValue1(wordsDivided[0]),
                                getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                                getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    } else{
                            return new HashSet<>(getIPsForUser(getSplitedEq(query), null, null));
                    }
                } else if(queryArray[1].equals("ip") &&queryArray[3].equals("date")){
                    if(queryArrayEq[1].contains(" and date between ")) {
                        return new HashSet<>(getBIGUniqueIPsExactDate(getSimpleDateFromText(getCleanDateValue1(wordsDivided[0])),
                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    } else {
                        return new HashSet<>(getUniqueIPsExactDate(getSimpleDateFromText(getSplitedEq(query))));
                    }
                } else if(queryArray[1].equals("ip") &&queryArray[3].equals("event")){
                    if(queryArrayEq[1].contains(" and date between ")) {
                        return new HashSet<>(getBIGUniqueIPsExactEvent(Event.valueOf(getCleanDateValue1(wordsDivided[0])),
                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    } else{
                        return new HashSet<>(getIPsForEvent(Event.valueOf(getSplited(query)),null,null));
                    }
                } else if(queryArray[1].equals("ip") &&queryArray[3].equals("status")){
                    if(queryArrayEq[1].contains(" and date between ")) {
                        return new HashSet<>(getBIGUniqueIPsExactStatus(Status.valueOf(getCleanDateValue1(wordsDivided[0])),
                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    }else {
                        return new HashSet<>(getIPsForStatus(Status.valueOf(getSplited(query)), null, null));
                    }
                }

                //User Block
                else if(queryArray[1].equals("user")&&queryArray[3].equals("ip")){
                    if(queryArrayEq[1].contains(" and date between ")) {
                        return new HashSet<>(getUsersForIP(getCleanDateValue1(wordsDivided[0]),
                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    }else {
                        return new HashSet<>(getUsersForIP(getSplited(query), null, null));
                    }
                } else if(queryArray[1].equals("user")&&queryArray[3].equals("date")){
                    if(queryArrayEq[1].contains(" and date between ")){
                        return new HashSet<>(getBIGUniqueUsersExactDate(getSimpleDateFromText(getCleanDateValue1(wordsDivided[0])),
                                getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                                getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    } else {
                        return new HashSet<>(getUniqueUsersExactDate(getSimpleDateFromText(getSplitedEq(query))));
                    }
                } else if(queryArray[1].equals("user")&&queryArray[3].equals("event")){
                    if(queryArrayEq[1].contains(" and date between ")){
                        return new HashSet<>(getBIGUniqueUsersExactEvent(Event.valueOf(getCleanDateValue1(wordsDivided[0])),
                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    } else {
                        return new HashSet<>(getUniqueUsersForEvent(Event.valueOf(getSplited(query))));
                    }
                }else if(queryArray[1].equals("user")&&queryArray[3].equals("status")){
                    if(queryArrayEq[1].contains(" and date between ")){
                        return new HashSet<>(getBIGUniqueUsersExactStatus(Status.valueOf(getCleanDateValue1(wordsDivided[0])),
                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    } else {
                        return new HashSet<>(getUniqueUsersForStatus(Status.valueOf(getSplited(query))));
                    }
                }
                //Date Block - 350
                else if(queryArray[1].equals("date")&&queryArray[3].equals("ip")){
                    if(queryArrayEq[1].contains(" and date between ")) {
                        return new HashSet<>(getUsersForIP(getCleanDateValue1(wordsDivided[0]),
                                getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
                                getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
                    }else {
                        return new HashSet<>(getDatesForIP(getSplited(query)));
                    }
                }else if(queryArray[1].equals("date")&&queryArray[3].equals("user")){
                    return new HashSet<>(getDatesForUser(getSplitedEq(query)));
                }else if(queryArray[1].equals("date")&&queryArray[3].equals("event")){
                    return new HashSet<>(getDatesForEvent(Event.valueOf(getSplited(query))));
                }else if(queryArray[1].equals("date")&&queryArray[3].equals("status")){
                    return new HashSet<>(getDatesForStatus(Status.valueOf(getSplited(query))));
                }
                //Event Block - 500
                else if(queryArray[1].equals("event")&&queryArray[3].equals("ip")){
                    return new HashSet<>(getEventsForIP(queryArray[5].replaceAll("^\"|\"$", ""),null,null));
                }else if(queryArray[1].equals("event")&&queryArray[3].equals("user")){
                    return new HashSet<>(getEventsForUser(getSplitedEq(query),null,null));
                }else if(queryArray[1].equals("event")&&queryArray[3].equals("date")){
                    return new HashSet<>(getUniqueEventsExactDate(getSimpleDateFromText(getSplitedEq(query))));
                }else if(queryArray[1].equals("event")&&queryArray[3].equals("status")){
                    return new HashSet<>(getUniqueEventsForStatus(Status.valueOf(getSplited(query))));
                }
                //Status Block
                else if(queryArray[1].equals("status")&&queryArray[3].equals("ip")){
                    return new HashSet<>(getStatusForIP(getSplited(query)));
                }else if(queryArray[1].equals("status")&&queryArray[3].equals("user")){
                    return new HashSet<>(getDatesStatusUser(getSplitedEq(query)));
                }else if(queryArray[1].equals("status")&&queryArray[3].equals("date")){
                    return new HashSet<>(getUniqueStatusExactDate(getSimpleDateFromText(getSplitedEq(query))));
                }else if(queryArray[1].equals("status")&&queryArray[3].equals("event")){
                    return new HashSet<>(getStatusForEvent(Event.valueOf(getSplited(query))));
                }
            //}
//            else{
////                String[] dividedByEqual = query.split("=");
////                String[] dividedSpace = dividedByEqual[0].split(" ");
////                //field1 - dividedSpace[1]
////                //field2 - dividedSpace[3]
////                String[] wordsDivided = dividedByEqual[1].split(" and date between ");
////                // value1 - wordsDivided[0]
////                String[] wordsDividedAnd = wordsDivided[1].split(" and ");
////                // after - wordsDividedAnd[0]
////                //before - wordsDividedAnd[1]
////                //IP Block
//                if(dividedSpace[1].equals("ip") &&dividedSpace[3].equals("user")){
//                    return new HashSet<>(getIPsForUser(getCleanDateValue1(wordsDivided[0]),
//                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
//                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//                } else if(dividedSpace[1].equals("ip") &&dividedSpace[3].equals("date")){
//                    return new HashSet<>(getBIGUniqueIPsExactDate(getSimpleDateFromText(getCleanDateValue1(wordsDivided[0])),
//                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
//                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//
//                } else if(dividedSpace[1].equals("ip") &&dividedSpace[3].equals("event")){
////                    return new HashSet<>(getIPsForEvent(Event.valueOf(getCleanDateValue1(wordsDivided[0])),
////                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
////                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//                    return new HashSet<>(getBIGUniqueIPsExactEvent(Event.valueOf(getCleanDateValue1(wordsDivided[0])),
//                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
//                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//
//                } else if(dividedSpace[1].equals("ip") &&dividedSpace[3].equals("status")){
////                    return new HashSet<>(getIPsForStatus(Status.valueOf(getCleanDateValue1(wordsDivided[0])),
////                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
////                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//                    return new HashSet<>(getBIGUniqueIPsExactStatus(Status.valueOf(getCleanDateValue1(wordsDivided[0])),
//                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
//                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//                }
//                //USER BLOCK
//                if(dividedSpace[1].equals("user") &&dividedSpace[3].equals("ip")){
//                    return new HashSet<>(getUsersForIP(getCleanDateValue1(wordsDivided[0]),
//                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
//                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//
//                } else if(dividedSpace[1].equals("user") &&dividedSpace[3].equals("date")){
//                    return new HashSet<>(getBIGUniqueUsersExactDate(getSimpleDateFromText(getCleanDateValue1(wordsDivided[0])),
//                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
//                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//
//                } else if(dividedSpace[1].equals("user") &&dividedSpace[3].equals("event")){
//                    return new HashSet<>(getBIGUniqueUsersExactEvent(Event.valueOf(getCleanDateValue1(wordsDivided[0])),
//                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
//                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//
//                } else if(dividedSpace[1].equals("user") &&dividedSpace[3].equals("status")){
//                    return new HashSet<>(getBIGUniqueUsersExactStatus(Status.valueOf(getCleanDateValue1(wordsDivided[0])),
//                            getSimpleDateFromText(getCleanDateAfter(wordsDividedAnd[0])),
//                            getSimpleDateFromText(getCleanDateBefore(wordsDividedAnd[1]))));
//                }
//
//
//
//                //DATE BLOCK - not Touched
//                if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("ip")){
//                    return new HashSet<>(getUsersForIP(wordsDivided[0],getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("user")){
//                    return new HashSet<>(getBIGUniqueUsersExactDate(getSimpleDateFromText(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("event")){
//                    return new HashSet<>(getBIGUniqueUsersExactEvent(Event.valueOf(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("status")){
//                    return new HashSet<>(getBIGUniqueUsersExactStatus(Status.valueOf(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                }
//                //EVENT BLOCK - not Touched
//                if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("ip")){
//                    return new HashSet<>(getUsersForIP(wordsDivided[0],getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("user")){
//                    return new HashSet<>(getBIGUniqueUsersExactDate(getSimpleDateFromText(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("event")){
//                    return new HashSet<>(getBIGUniqueUsersExactEvent(Event.valueOf(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("status")){
//                    return new HashSet<>(getBIGUniqueUsersExactStatus(Status.valueOf(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                }
//                //STATUS BLOCK - not Touched
//                if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("ip")){
//                    return new HashSet<>(getUsersForIP(wordsDivided[0],getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("user")){
//                    return new HashSet<>(getBIGUniqueUsersExactDate(getSimpleDateFromText(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("event")){
//                    return new HashSet<>(getBIGUniqueUsersExactEvent(Event.valueOf(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                } else if(dividedSpace[1].equals("date") &&dividedSpace[3].equals("status")){
//                    return new HashSet<>(getBIGUniqueUsersExactStatus(Status.valueOf(wordsDivided[0]),getSimpleDateFromText(wordsDividedAnd[0]),getSimpleDateFromText(wordsDividedAnd[1])));
//                }
//
//
//            }

        }



        return null;
    }
}