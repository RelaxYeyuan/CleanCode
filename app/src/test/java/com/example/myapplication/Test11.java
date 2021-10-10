package com.example.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test11 {

    @Test
    public void test() {
        TestLinkedList linkedList = new TestLinkedList();
        linkedList.addToEnd(4);
        linkedList.addToEnd(1);
        linkedList.addToEnd(2);

        for (int i = 0; i < linkedList.size; i++) {
            System.out.println("位置 " + i + " " + linkedList.get(i));
        }

        System.out.println("添加指定3到1");

        linkedList.addToMiddle(3, 1);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println("位置 " + i + " " + linkedList.get(i));
        }
        System.out.println("添加指定66到0");
        linkedList.addToMiddle(66, 0);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println("位置 " + i + " " + linkedList.get(i));
        }
        System.out.println("添加指定88到1");
        linkedList.addToMiddle(88, 1);

        for (int i = 0; i < linkedList.size; i++) {
            System.out.println("位置 " + i + " " + linkedList.get(i));
        }

        System.out.println("删除后");

        linkedList.remove(1);
        linkedList.remove(-1);
        linkedList.remove(6);

        for (int i = 0; i < linkedList.size; i++) {
            System.out.println("位置 " + i + " " + linkedList.get(i));
        }
    }
}
