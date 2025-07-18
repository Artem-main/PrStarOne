package edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList <Integer> myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
    }

    @Test
    void add() {
        assertEquals(2,myArrayList.size());
    }

    @Test
    void remove() {
        myArrayList.remove(1);
        assertEquals(1,myArrayList.size());
    }

    @Test
    void get() {
        assertEquals(1,myArrayList.get(0));
    }

    @Test
    void size() {
        assertEquals(2,myArrayList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void clear() {
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(myArrayList.contains(1));
        assertTrue(myArrayList.contains(2));
    }

    @Test
    void iterator() {
        // Получаем итератор
        Iterator<Integer> myIterator = myArrayList.iterator();

        // Проверяем, что есть элементы
        assertTrue(myIterator.hasNext());

        // Проверяем первый элемент
        assertEquals(1, myIterator.next());

        // Проверяем второй элемент
        assertEquals(2, myIterator.next());

        // Проверяем, что больше нет элементов
        assertFalse(myIterator.hasNext());

        // Удаляем второй элемент
        myIterator.remove();

        // Проверяем, что остался один элемент
        assertEquals(1, myArrayList.size());

        // Проверяем оставшиеся элементы
        myIterator = myArrayList.iterator();
        assertEquals(1, myIterator.next());
    }
}