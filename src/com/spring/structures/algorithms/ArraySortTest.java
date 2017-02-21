package com.spring.structures.algorithms;

import org.junit.Test;

public class ArraySortTest {
    @Test
    public void insertSortTest() {
        SortList<String> sortTemp = new SortList<String>(6);
        sortTemp.add("1");
        sortTemp.add("5");
        sortTemp.add("2");
        sortTemp.add("5");
        sortTemp.add("3");
        sortTemp.add("5");
        String[] strArray = (String[]) sortTemp.elementData;
        insertSort(strArray);
        display(strArray);
    }

    public String[] insertSort(String[] strArray) {
        int out, in;
        for (out = 1; out < strArray.length - 1; out++) {
            String strTemp = strArray[out];
            in = out;
            while (in > 0 && strTemp.compareTo(strArray[in - 1]) < 0) {
                strArray[in] = strArray[in - 1];
                in--;
            }
            strArray[in] = strTemp;
        }
        return strArray;
    }

    public void display(String[] e) {
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }
}
