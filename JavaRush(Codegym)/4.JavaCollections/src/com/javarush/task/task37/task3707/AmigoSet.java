package com.javarush.task.task37.task3707;

import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        if(map.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        if(map.containsKey(o)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return super.remove(o);
    }

    @Override
    public Object clone() throws InternalError {

        try{
            AmigoSet newAmigo = (AmigoSet) super.clone();
            newAmigo.map = (HashMap)map.clone();
            return newAmigo;
        }catch (Exception e){
            throw new InternalError();
        }
    }
    private void writeObject(ObjectOutputStream paramOne) throws IOException {
        paramOne.defaultWriteObject();

        paramOne.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        paramOne.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        paramOne.writeInt(map.size());

        for(E e:map.keySet()) paramOne.writeObject(e);

    }
    private void readObject(ObjectInputStream paramOne) throws IOException, ClassNotFoundException {
        paramOne.defaultReadObject();

        int capacity = paramOne.readInt();
        float loadFactor = paramOne.readFloat();
        int size = paramOne.readInt();

        map = new HashMap<>(capacity,loadFactor);
        for(int i=0; i < size; i++){
            E e = (E) paramOne.readObject();
            map.put(e,PRESENT);
        }

    }
    @Override
    public boolean equals(Object o) {

        if ((o == null)||!(o instanceof AmigoSet )) return false;

        if (this.hashCode()!= ((AmigoSet)o).hashCode()) return false;
        AmigoSet<E> compare = (AmigoSet)o;
        if (this.map.size()!= compare.map.size()) return false;
        for (E e: map.keySet()){
            if (!compare.contains(e)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.map.hashCode()*31+PRESENT.hashCode();
    }

    @Override
    public Object[] toArray() {
        return this.map.keySet().toArray();
    }

//    @Override
//    public <T> T[] toArray(T[] a) {
//        return this.map.keySet().toArray(a);
//    }

}
