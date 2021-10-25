package com.example.myapplication;


import org.junit.Test;

/**
 * @author by chenhongrui on 2021/10/21
 * <p>
 * 内容摘要:
 * 版权所有：Semisky
 * 修改内容：
 * 修改日期
 */
public class QuickSort {

    @Test
    public void test() {
        int[] array = new int[]{1, 4, 2, 6, 8, 5, 9, 3, 7};
        quickSort(array, 0, array.length - 1);

        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    /**
     * 拿第一个数据x
     * low指针从左往右找比x大的值，找到就放到high指针位置
     * high指针从右往左找比x小的值，找到就放在low指针位置
     * 相遇就把T放在相遇的位置
     * 结果：T左边的比T小，右边比T大
     *
     * @param array 数组
     * @param begin 开始
     * @param end   结束
     */
    private void quickSort(int[] array, int begin, int end) {
        if (end - begin <= 0) return;
        //第一格数据
        int x = array[begin];
        int low = begin;
        int high = end;

        //方向 true从右往左，false从左往右
        boolean direction = true;
        L1:
        while (low < high) {
            if (direction) {
                //操作high指针，从右往左查询
                for (int i = high; i > low; i--) {
                    if (array[i] <= x) {
                        //1.数据移到low位置。
                        array[low] = array[i];
                        //低指针右移
                        low++;
                        //2.high移到i
                        high = i;
                        //换方向
                        direction = !direction;
                        continue L1;
                    }
                }
                //指针重合
                high = low;
            } else {
                //操作low指针，从左往右查询
                for (int i = low; i < high; i++) {
                    if (array[i] >= x) {
                        //1.数据移到high位置
                        array[high] = array[i];
                        high--;
                        //2.low指针移到i
                        low = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                //指针重合
                low = high;
            }
        }
        //最后一步，把最初查找的值放入指针重合的位置
        array[low] = x;
        //开始完成左右两边的操作
        //重合左半边的操作,从0开始，到low结束
        quickSort(array, begin, low - 1);
        //重合位置的右半边的操作，从low开始，length-1结束
        quickSort(array, low + 1, end);
    }
}
