package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
//    Entry<String> root;
//
//    public CustomTree(Entry<String> root){
//        this.root = root;
//    }


    @Override
    public boolean add(String elementName) {
        return super.add(elementName);
    }



    @Override
    public String get(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
        //return null;
    }

    @Override
    public int size() {

        return 0;
    }

    public String getParent(String s){
        return s;
    }

    @Override
    public String set(int index, String element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
        //return super.set(index, element);
    }

    @Override
    public void add(int index, String element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
        //super.add(index, element);
    }

    @Override
    public String remove(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
        //return super.remove(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }
    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;


        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry (String name){
            this.elementName = name;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            if(availableToAddLeftChildren || availableToAddRightChildren) return true;
            else return false;
        }

    }

}
