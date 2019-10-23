package com.javarush.task.task37.task3707;

import java.awt.List;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable,Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<E,Object>();
    }
    public AmigoSet(Collection<? extends E> collection) {
       float Capacity = Math.max(16, (collection.size()/.75f)) ;
       HashMap<E,Object> newmap = new HashMap<>(Math.max((int) Math.ceil(collection.size()/.75f), 16));
       for(E elem:collection){
           newmap.put(elem,PRESENT);
       }
       this.map = newmap;

    }

    @Override
    public boolean add(Object e) {
        return null==map.put((E) e,PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        ArrayList<E> keysList = new ArrayList<>();
        for(Map.Entry elem:map.entrySet()){
            keysList.add((E) elem.getKey());
        }
        return (Iterator<E>) keysList;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }
}
