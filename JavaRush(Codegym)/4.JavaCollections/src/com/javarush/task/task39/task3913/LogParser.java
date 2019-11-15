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

        }
        return dateFromList;
    }


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
    //******Helper Date


    //*********PART5

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

            if(!queryArray[1].isEmpty()){
                //IP Block
                if(queryArray[1].equals("ip") &&queryArray[3].equals("user")){
                    return new HashSet<>(getIPsForUser(queryArray[5].replaceAll("^\"|\"$", ""),null,null));
                } else if(queryArray[1].equals("ip") &&queryArray[3].equals("date")){
                    return new HashSet<>(getUniqueIPs(getDateFromText(queryArray[5].replaceAll("^\"|\"$", "")),null));
                } else if(queryArray[1].equals("ip") &&queryArray[3].equals("event")){
                    return new HashSet<>(getIPsForEvent(Event.valueOf(queryArray[5].replaceAll("^\"|\"$", "")),null,null));
                } else if(queryArray[1].equals("ip") &&queryArray[3].equals("status")){
                    return new HashSet<>(getIPsForStatus(Status.valueOf(queryArray[5].replaceAll("^\"|\"$", "")),null,null));
                }
                //User Block
                else if(queryArray[1].equals("user")&&queryArray[3].equals("ip")){
                    return new HashSet<>(getUsersForIP(queryArray[5].replaceAll("^\"|\"$", ""),null,null));
                } else if(queryArray[1].equals("user")&&queryArray[3].equals("date")){
                    //?
                    return new HashSet<>(getNumberOfUserEvents(queryArray[5].replaceAll("^\"|\"$", ""),null,null));
                } else if(queryArray[1].equals("user")&&queryArray[3].equals("event")){
                    return new HashSet<>();
                }
                //Event Block






                else if(queryArray[1].equals("date")){

                }else if(queryArray[1].equals("event")){

                }else if(queryArray[1].equals("status")){

                }

            }



        }



        return null;
    }
}