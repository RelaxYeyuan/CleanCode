package com.example.myapplication;

import java.util.LinkedList;

public class JavaTest {

    private void test() {
        bubbleTest(new int[]{3, 1, 4, 6, 2, 9, 7, 5});
    }

    private void bubbleTest(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
        }
    }
}
