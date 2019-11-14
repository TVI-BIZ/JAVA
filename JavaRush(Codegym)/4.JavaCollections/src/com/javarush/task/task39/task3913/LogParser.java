package com.javarush.task.task39.task3913;

import com.javarush.task.task37.task3711.Memory;
import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        File folder = new File(logDir.toString());
        File[] listOfFiles = folder.listFiles();
        BufferedReader reader;
        String fileEndPath="";
        List<String> fileDataArray = new ArrayList<>();

        //absolute path to file
        for(File elem:listOfFiles){
            fileEndPath = elem.getAbsolutePath();
        }
        //read data from file and store it in list.
        try{
            reader = new BufferedReader(new FileReader(fileEndPath));
            String textline = reader.readLine();
            while (textline !=null){
                System.out.println(textline);
                fileDataArray.add(textline);
                textline = reader.readLine();
            }
            reader.close();
        }catch (Exception e){
            System.out.println(e);
        }
        //IP Regex
       Pattern ptn = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
       Pattern ptnData = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})\\s(\\d{2})\\:(\\d{2})");
        //Data Format Parser
        String data_pattern = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(data_pattern);

        List<String> ipList = new ArrayList<>();
        for(String elem:fileDataArray){
            Matcher mtch=ptn.matcher(elem);
            Matcher mtch2 = ptnData.matcher(elem);
            while (mtch.find()){
                ipList.add(mtch.group());
            }
            while (mtch2.find()){
                System.out.println(mtch2.group());
            }
            //Date date = simpleDateFormat.parse();
        }
//        for(String elem:ipList){
//            System.out.println(elem);
//        }


        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}