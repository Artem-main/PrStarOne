package edu;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList <E> implements CustomArrayList <E> {

    private final ArrayList<E> myList = new ArrayList<>();

    @Override
    public boolean add(E element) {
        myList.add(element);
        return true;
    }

    @Override
    public boolean remove(E element) {
        myList.remove(element);
        return true;
    }

    @Override
    public E get(int index) {
        return myList.get(index);
    }

    @Override
    public int size() {
        return myList.size();
    }

    @Override
    public boolean isEmpty() {
        myList.isEmpty();
        return true;
    }

    @Override
    public void clear() {
        myList.clear();
    }

    @Override
    public boolean contains(E element) {
        return myList.contains(element);
    }

    @Override
    public Iterator iterator() {
        return myList.listIterator();
    }
}
