package com.javarush.task.task33.task3310.strategy;

import java.io.File;

public class FileStorageStrategy implements StorageStrategy {
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private long maxBucketSize = 0;

    public FileStorageStrategy() {
        for(int i = 0; i < table.length; i++){
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }


    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, indexFor(hash(key), table.length));
    }
//
    @Override
    public Long getKey(String value) {
        if (value == null)
            return 0l;
        for (FileBucket aTable : table) {
            for (Entry e = aTable.getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return aTable.getEntry().getKey();
        }
        return null;
    }
//
    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i].getEntry() ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

    @Override
    public String getValue(Long key) {
        if(getEntry(key)!=null){
            return getEntry(key).getValue();
        } else{
            return null;
        }
    }

    public int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length){
        return hash & (length - 1);
    }

    public Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }


//
    public void resize(int newCapacity){


        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);

//        for(FileBucket elem: table){
//            elem.remove();
//        }

        table = newTable;
        maxBucketSize = (int)Math.min(newCapacity,DEFAULT_INITIAL_CAPACITY);
    }




    public void transfer(FileBucket[] newTable){
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j].getEntry();
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i].getEntry();
                    newTable[i].putEntry(e);
                    e = next;
                } while (e != null);
            }
            src[j].remove();
        }
    }




    public void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        for(FileBucket elem:table){
            if(elem.getFileSize()>getBucketSizeLimit()){
                resize(2 * table.length);
            }
        }
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }


}

//variant1
//
//@Override
//public boolean containsKey(Long key) {
//    return getEntry(key) != null;
//}
//    //
//    @Override
//    public void put(Long key, String value) {
//        addEntry(hash(key), key, value, indexFor(hash(key), table.length));
//    }
//    //
////    @Override
//    public Long getKey(String value) {
//        if (value == null)
//            return 0l;
//        for (FileBucket aTable : table) {
//            for (FileBucket e = aTable; e != null; e = e)
//                if (value.equals(e.toString()))
//                    return aTable.getFileSize();
//        }
//        return null;
//    }
//    //
//    @Override
//    public boolean containsValue(String value) {
//        if (value == null)
//            return false;
//
//        FileBucket[] tab = table;
//        for (int i = 0; i < tab.length ; i++)
//            for (FileBucket e = tab[i] ; e != null ; e = e)
//                if (value.equals(e))
//                    return true;
//        return false;
//    }
//
//    @Override
//    public String getValue(Long key) {
//        if(getEntry(key)!=null){
//            return getEntry(key).toString();
//        } else{
//            return null;
//        }
//    }
//    //
//    public int hash(Long k){
//        int h;
//        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
//    }
//    //
//    public int indexFor(int hash, int length){
//        return hash & (length - 1);
//    }
//    //
//    public FileBucket getEntry(Long key){
//        int hash = (key == null) ? 0 : hash(key);
//        for (FileBucket e = table[indexFor(hash, table.length)];
//             e != null;
//             e = e) {
//            Object k;
//            if (e.hashCode() == hash &&
//                    ((k = e.getFileSize()) == key || (key != null && key.equals(k))))
//                return e;
//        }
//        return null;
//    }
//
//    public void resize(int newCapacity){
//        FileBucket[] oldTable = table;
//        int oldCapacity = oldTable.length;
//        if (oldCapacity == DEFAULT_INITIAL_CAPACITY) {
//            bucketSizeLimit = Integer.MAX_VALUE;
//            return;
//        }
//
//        FileBucket[] newTable = new FileBucket[newCapacity];
//        transfer(newTable);
//        table = newTable;
//        bucketSizeLimit = (int)(newCapacity * 2);
//    }
//
//    public void transfer(FileBucket[] newTable){
//        FileBucket[] src = table;
//        int newCapacity = newTable.length;
//        for (int j = 0; j < src.length; j++) {
//            FileBucket e = src[j];
//            if (e != null) {
//                src[j] = null;
//                do {
//                    FileBucket next = e;
//                    int i = indexFor(e.hashCode(), newCapacity);
//                    e = newTable[i];
//                    newTable[i] = e;
//                    e = next;
//                } while (e != null);
//            }
//        }
//    }
//    public void addEntry(int hash, Long key, String value, int bucketIndex){
//        FileBucket e = table[bucketIndex];
//        table[bucketIndex] = new FileBucket();
//        if (size++ >= bucketSizeLimit)
//            resize(2 * table.length);
//    }
//    public void createEntry(int hash, Long key, String value, int bucketIndex){
//        FileBucket e = table[bucketIndex];
//        table[bucketIndex] = new FileBucket();
//        size++;
//    }