package edu;

import java.util.ArrayList;
import java.util.Iterator;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {

    public DefaultCustomArrayList() {
    }

    ArrayList<E> list = new ArrayList<>();

    @Override
    public boolean add(E element) {
        return true;
    }

    @Override
    public boolean remove(E element) {
        return  list.contains(element);
    }

    private void remove(int index) {
        list.remove(index);
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
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}