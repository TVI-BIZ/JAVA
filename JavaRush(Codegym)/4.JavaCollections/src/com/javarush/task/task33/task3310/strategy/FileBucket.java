package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.Helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try{
            path = Files.createTempFile(null,null);
            Files.deleteIfExists(path);
            path.toFile().deleteOnExit();
            Files.createFile(path);
        } catch (Exception e){
        }
    }

    public long getFileSize() {
        try{
            return Files.size(path);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
    public void putEntry(Entry entry){
        try{
            OutputStream out = Files.newOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(entry);
            out.close();
            objectOutputStream.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }


   //чтобы получить InputStream используй метод Files.newInputStream.
    public Entry getEntry(){
        if(getFileSize()==0){
            return null;
        }

        Entry res=null;
        try{
            InputStream in = Files.newInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            res = (Entry)objectInputStream.readObject();
            in.close();
            objectInputStream.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return res;
    }


    public void remove(){
        try{
            Files.delete(path);
        } catch (Exception e){

        }

    }


}
