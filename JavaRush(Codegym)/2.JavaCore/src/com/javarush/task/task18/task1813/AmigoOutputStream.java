package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream fileOutputStream = new FileOutputStream(fileName);

    public AmigoOutputStream(FileOutputStream fileOut) throws FileNotFoundException {
        super(fileName);

    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.flush();
        String writed = "JavaRush © All rights reserved.";
//        InputStream is = new ByteArrayInputStream(writed.getBytes());
//        System.setIn(is);
//
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(isr);

        fileOutputStream.write(writed.getBytes());

//        reader.close();
//        isr.close();
        fileOutputStream.close();



    }
}
