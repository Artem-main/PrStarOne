package edu;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList <E> implements CustomArrayList <E> {

    private final ArrayList<E> myList = new ArrayList<>();

    @Override
    public boolean add(E element) {
        try {
            return myList.add(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректное числовое значение" + e);
        } catch (NullPointerException e) {
            throw new NullPointerException("Нельзя добавить null" + e);
        }
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
        return myList.isEmpty();;
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
