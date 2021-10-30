package com.example.myapplication;


import org.junit.Test;

/**
 * @author by chenhongrui on 2021/10/25
 * <p>
 * 内容摘要: 归并排序
 */
public class MergeTest {

    @Test
    public void test() {
        int[] array = new int[]{5, 2, 8, 6, 1, 3, 7, 4, 9};
        mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    public void mergeSort(int array[], int left, int right) {
        if (left == right) {
            return;
        } else {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid + 1, right);
        }
    }


    /**
     * 合并
     *
     * @param array 数组
     * @param left  起始位置
     * @param mid   中间位置
     * @param right 末尾位置
     */
    public static void merge(int[] array, int left, int mid, int right) {
        //以mid为中间，计算两边的大小
        int leftSize = mid - left;
        int rightSize = right - mid + 1;

        //把原数组分割成两个数组
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        //填充数据
        for (int i = left; i < mid; i++) {
            leftArray[i - left] = array[i];
        }

        for (int i = mid; i <= right; i++) {
            rightArray[i - mid] = array[i];
        }

        //合并
        int i = 0;
        int j = 0;
        int k = left;

        //i和j比大小，较大的数放在k，i++和j++
        //当i或者j到最大值时，就把剩下的值移到k
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] < rightArray[j]) {
                array[k] = leftArray[i];
                k++;
                i++;
            } else {
                array[k] = rightArray[j];
                k++;
                j++;
            }
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            k++;
            i++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            k++;
            j++;
        }
    }
}
