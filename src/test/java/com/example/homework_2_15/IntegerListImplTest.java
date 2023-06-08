package com.example.homework_2_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private IntegerListImpl list;

    @BeforeEach
    void setUp() {
        list = new IntegerListImpl();
    }

    @Test
    void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }

    @Test
    void testAddAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 4);

        assertEquals(4, list.size());
        assertEquals(1, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
    }

    @Test
    void testSet() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testRemoveByValue() {
        list.add(1);
        list.add(2);
        list.add(3);
        Integer removedItem = list.remove(Integer.valueOf(2));

        assertEquals(2, list.size());
        assertEquals(2, removedItem);
        assertFalse(list.contains(2));
    }

    @Test
    void testRemoveByIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        Integer removedItem = list.remove(1);

        assertEquals(2, list.size());
        assertEquals(2, removedItem);
        assertFalse(list.contains(2));
    }

    @Test
    void testContains() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }

    @Test
    void testIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void testLastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);

        assertEquals(2, list.lastIndexOf(2));
        assertEquals(-1, list.lastIndexOf(4));
    }

    @Test
    void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testEquals() {
        list.add(1);
        list.add(2);
        list.add(3);

        IntegerListImpl otherList = new IntegerListImpl();
        otherList.add(1);
        otherList.add(2);
        otherList.add(3);

        assertTrue(list.equals(otherList));
    }

    @Test
    void testSize() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    void testToArray() {
        list.add(1);
        list.add(2);
        list.add(3);

        Integer[] array = list.toArray();

        assertEquals(3, array.length);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    void testAdd_NullItem_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            list.add(null);
        });
    }

    @Test
    void testAddAtIndex_InvalidIndex_ThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(10, 5);
        });
    }

    @Test
    void testSet_InvalidIndex_ThrowsIndexOutOfBoundsException() {
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(2, 3);
        });
    }

    @Test
    void testRemoveByValue_NullItem_ThrowsIllegalArgumentException() {
        list.add(1);
        list.add(2);

        assertThrows(IllegalArgumentException.class, () -> {
            list.remove(null);
        });
    }

    @Test
    void testRemoveByIndex_InvalidIndex_ThrowsIndexOutOfBoundsException() {
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);
        });
    }

    @Test
    void testContains_NullItem_ThrowsIllegalArgumentException() {
        list.add(1);
        list.add(2);

        assertThrows(IllegalArgumentException.class, () -> {
            list.contains(null);
        });
    }

    @Test
    void testIndexOf_NullItem_ThrowsIllegalArgumentException() {
        list.add(1);
        list.add(2);

        assertThrows(IllegalArgumentException.class, () -> {
            list.indexOf(null);
        });
    }

    @Test
    void testLastIndexOf_NullItem_ThrowsIllegalArgumentException() {
        list.add(1);
        list.add(2);

        assertThrows(IllegalArgumentException.class, () -> {
            list.lastIndexOf(null);
        });
    }

    @Test
    void testGet_InvalidIndex_ThrowsIndexOutOfBoundsException() {
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }

    @Test
    void testEquals_NullList_ThrowsIllegalArgumentException() {
        list.add(1);
        list.add(2);

        assertThrows(IllegalArgumentException.class, () -> {
            list.equals(null);
        });
    }
}