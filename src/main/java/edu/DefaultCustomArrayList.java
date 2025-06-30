package edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {

    public DefaultCustomArrayList() {
    }

    ArrayList<E> list = new ArrayList<>();

    @Override
    public boolean add(E element) {
        list.addAll(Collections.singleton(element));
        return true;
    }

    @Override
    public boolean remove(E element) {
        list.remove(1);
        return  list.contains(element);
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(E element) {
        if (list.contains(element)) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}