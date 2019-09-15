package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String res1 = "";
        @Override
        public void setFileName(String fullFileName) {
            firstFileName = fullFileName;
        }



        @Override
        public void run() {
            //res1 = "";
            BufferedReader reader2 = null;
            try {
                reader2 = new BufferedReader(new FileReader(firstFileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    if (!reader2.ready()) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String line = null;
                try {
                    line = reader2.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                res1 += line + " ";
            }
        }
        @Override
        public String getFileContent() throws IOException {
            //res1 = "";
//            BufferedReader reader2 = new BufferedReader(new FileReader(firstFileName));
//            while (reader2.ready()){
//            String line = reader2.readLine();
//            res1 += line + " ";
//            }
            //run();
            return res1;
        }



    }






    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.run();
        //add your code here - добавьте код тут
        f.join();


        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();

        void run();

    }

    //add your code here - добавьте код тут

}
