package com.example.myapplication;

import org.junit.Test;

/**
 * @author by chenhongrui on 2021/10/20
 * <p>
 * 内容摘要: 二分查找
 * 版权所有：Semisky
 * 修改内容：
 * 修改日期
 */
public class DoubleHalfQuery {

    @Test
    public void test() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = binarySearch(array, 0, array.length, 11);
        System.out.println(index);
    }

    private int binarySearch(int[] array, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        //减一为了解决连续性的问题，比如先查找0到3，再查找3-5，3就不会重复查找
        int high = toIndex - 1;
        while (low <= high) {
//            int mid = (low + high) >> 1;
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (key > midVal) {
                low = mid + 1;
            } else if (key < midVal) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
