package com.spring.structures.algorithms;

import java.util.Arrays;

import com.spring.structures.SortListException;

public class SortList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final String[] EMPTY_ELEMENTDATA = {};
    public String[] elementData;
    private int size;

    public SortList() {
        this.elementData = new String[DEFAULT_CAPACITY];
    }

    public SortList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new String[initialCapacity];
        } else if (0 == initialCapacity) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new SortListException("Illegal Capacity:" + initialCapacity);
        }
    }

    public boolean add(String e) {
        ensureCapacity(this.size + 1);
        this.elementData[size++] = e;
        return true;
    }

    public void display(String[] e) {
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - this.elementData.length > 0)
            grow(minCapacity);
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        if (newCapacity > MAX_ARRAY_SIZE)
            newCapacity = hugeCapacity(newCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new SortListException("Illegal Capacity:" + minCapacity);
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;

    }
}
