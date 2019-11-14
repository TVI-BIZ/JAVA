package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache lruCache;
    private OriginalRetriever originalRetriever;
    Storage storage;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache(5);
    }
    //Метод retrieve класса CachingProxyRetriever должен получать объект из хранилища
    // с помощью метода retrieve объекта типа OriginalRetriever и добавлять в кеш,
    // если он не был там найден.

    //Метод retrieve класса CachingProxyRetriever должен возвращать объект,
    // которому в хранилище соответствует id, полученный в качестве параметра.

    @Override
    public Object retrieve(long id) {
        //lruCache.find(id)
        if(lruCache.find(id) != null){
            return lruCache.find(id);
        } else {
            //originalRetriever.retrieve(id);
            lruCache.set(id, originalRetriever.retrieve(id));
            return storage.get(id);
        }
    }

}
