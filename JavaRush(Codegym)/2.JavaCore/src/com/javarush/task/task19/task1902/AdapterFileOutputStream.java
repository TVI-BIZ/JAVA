package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

//import com.javarush.task.task18.task1812.AmigoOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;


    public AdapterFileOutputStream( FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }


    public static void main(String[] args) {

    }



    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        this.fileOutputStream.write(s.getBytes());

    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.close();
    }
}

