package edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList <Integer> myArrayList;
    private Iterator <Integer> myIterator;

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
        assertFalse(myArrayList.contains(1), "Элемента нет в списке");
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
        assertEquals(2,myArrayList.size());
        myArrayList.clear();
        assertEquals(0,myArrayList.size());
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
        myIterator = myArrayList.iterator();
        // Проверяем, что есть элементы
        assertTrue(myIterator.hasNext());
        // Проверяем первый элемент
        assertEquals(1, myIterator.next());
        // Проверяем второй элемент
        assertEquals(2, myIterator.next());
    }
    @Test
    void iteratorNonIndex() {
        myIterator = myArrayList.iterator();
        assertNotEquals(2,myIterator.next(),"Нет такого элемента");
    }

    @Test
    void iteratorRemoveElement() {
        myIterator = myArrayList.iterator();
        assertEquals(2, myArrayList.size());
        while (myIterator.hasNext()) {
            myIterator.next();
            myIterator.remove();
        }
        assertEquals(0, myArrayList.size());
    }

    @Test
    void iteratorOverCountElements() {
        Random random = new Random();
        int count = 10000;
        for (int i = 0; i < count; i++) {
            myArrayList.add(random.nextInt(100));
        }
        assertEquals(count+2, myArrayList.size());
    }

    @Test
    void testInvalidInput() {
        // Проверяем, что при невалидном вводе выбрасывается исключение
        assertThrows(
                NumberFormatException.class, // Ожидаемый тип исключения
                () -> myArrayList.add(Integer.valueOf("abc")),    // Код, который может выбросить исключение
                "Ожидалось исключение при парсинге невалидного числа"
        );
    }

    @Test
    void testNullInput() {
        // Проверяем обработку null
        assertThrows(
                NullPointerException.class,
                () -> myArrayList.add(null),
                "Ожидалось исключение при парсинге null"
        );
    }
}