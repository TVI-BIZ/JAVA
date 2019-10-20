package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        //напишите тут ваш код
        if(softReference != null){
            return softReference.get();
        }else{
            return null;
        }

    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> res = null;

        if(cacheMap.get(key) == null){
            res = null;
        } else {

            res = cacheMap.get(key);
        }

        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        if(softReference != null){

        }


        softReference.clear();
        //Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value.
        // Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
        // Иначе - верни предыдущее значение value по этому ключу.
        // Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
        //напишите тут ваш код

        return res.get();

    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> res = null;

        if(cacheMap.get(key).get() != null){
            res = cacheMap.get(key);
        } else {
            res = null;
        }


        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        softReference.clear();
        //Метод AnyObject remove(Long key) должен удалить из мапы cacheMap пару key : value по ключу key.
        // Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
        // Иначе - верни предыдущее значение value по этому ключу.
        // Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

        //напишите тут ваш код
        return res.get();
    }
}