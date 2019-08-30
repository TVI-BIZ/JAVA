package com.javarush.task.task17.task1713;

import java.util.*;

/* 
Общий список
*/

public class Solution implements java.util.List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    @Override
    public synchronized int size() {
        original.size();
        return 0;
    }

    @Override
    public synchronized boolean isEmpty() {
        original.isEmpty();
        return false;
    }

    @Override
    public synchronized boolean contains(Object o) {
        original.contains(o);
        return false;
    }

    @Override
    public synchronized Iterator iterator() {
        original.iterator();
        return null;
    }

    @Override
    public synchronized Object[] toArray() {
        original.toArray();
        return new Object[0];
    }

    @Override
    public synchronized boolean add(Long aLong) {
        original.add(aLong);
        return false;
    }


    @Override
    public synchronized boolean remove(Object o) {
        original.remove(o);
        return false;
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        original.addAll(c);
        return false;
    }

    @Override
    public synchronized boolean addAll(int index, Collection c) {
        original.addAll(index,c);
        return false;
    }

    @Override
    public synchronized void clear() {
        original.clear();

    }

    @Override
    public synchronized Long get(int index) {
        original.get(index);
        return null;
    }


    @Override
    public synchronized Long set(int index, Long element) {
        original.set(index,element);
        return null;
    }

    @Override
    public synchronized void add(int index, Long element) {
        original.add(index,element);

    }

    @Override
    public synchronized Long remove(int index) {
        original.remove(index);
        return null;
    }


    @Override
    public synchronized int indexOf(Object o) {
        original.indexOf(o);
        return 0;
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        original.lastIndexOf(o);
        return 0;
    }

    @Override
    public synchronized ListIterator listIterator() {
        original.listIterator();
        return null;
    }

    @Override
    public synchronized ListIterator listIterator(int index) {
        original.listIterator(index);
        return null;
    }

    @Override
    public synchronized List subList(int fromIndex, int toIndex) {
        original.subList(fromIndex,toIndex);
        return null;
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        original.retainAll(c);
        return false;
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        original.removeAll(c);
        return false;
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        original.containsAll(c);
        return false;
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        original.toArray(a);
        return new Object[0];
    }
}
