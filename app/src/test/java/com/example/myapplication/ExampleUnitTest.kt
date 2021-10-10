package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test() {
        tt(3)
    }

    /**
     * 冒泡排序
     * 每次循环把最大值置于末尾，从而得到从小到大的数组
     */
    private fun bubbleTest(array: IntArray) {

        for (i in array) {
            print("移动前：$i ")
        }

        println()

        for (j in 0 until array.size - 1) {
            var flag = true
            for (i in 0 until array.size - 1 - j) {
                if (array[i] > array[i + 1]) {
                    val temp = array[i + 1]
                    array[i + 1] = array[i]
                    array[i] = temp

                    flag = false
                }
            }

            if (flag) {
                break
            }
        }
        for (i in array) {
            print("移动后：$i ")
        }
    }

    /**
     * 选择排序：从第一个下标开始，从数组的第二个值开始比较，得到最小值所对应的下标，然后和第一个值进行交换
     * 第一次循环 8 3 1 6 5 ; index = 0 = 8
     * 1:3 8 1 6 5
     * 2:3 1 8 6 5
     * 3:3 1 6 8 5
     * 4:3 1 6 5 8
     * 5:1 3 6 5 8
     * 第二次循环 1 3 6 5 8 ; index = 1 = 3
     * 1:3 6 5 8
     * 2:3 6 5 8
     * 3:3 5 6 8
     * 4:3 5 6 8
     */
    private fun selectSort(array: IntArray) {
        for (i in array) {
            print("移动前：$i ")
        }
        println()

        for (j in array.indices) {
            var index = j
            for (i in j + 1 until array.size) {
                if (array[i] < array[index]) {
                    index = i
                }
            }
            if (index != j) {
                val temp = array[index]
                array[index] = array[j]
                array[j] = temp
            }
        }
        for (i in array) {
            print("移动后：$i ")
        }
    }


    /**
     * 汉诺塔
     * 盘子移动分为三步，假设有n个盘子
     * 1.除了最后一个盘子，其他盘子n-1从start开始，通过end柱子中转，移动到middle
     * 2.最后一个盘子从start移动到end柱子
     * 3.其他盘子n-1从middle开始，通过start柱子中转，移动到end
     * @param i 盘子的个数
     * @param start 盘子从这根柱子移动
     * @param middle 盘子经过这根盘子中转
     * @param end 盘子移动到这根柱子
     *
     *  盘子 1 从柱子 1 移动到柱子 3
    盘子 2 从柱子 1 移动到柱子 2
    盘子 1 从柱子 3 移动到柱子 2
    盘子 3 从柱子 1 移动到柱子 3
    盘子 1 从柱子 2 移动到柱子 1
    盘子 2 从柱子 2 移动到柱子 3
    盘子 1 从柱子 1 移动到柱子 3
     */
    private fun han(i: Int, start: Int, middle: Int, end: Int) {
        //如果移动到了最后
        if (i <= 1) {
            System.out.println("盘子 $i 从柱子 $start 移动到柱子 $end ")
        } else {
            han(i - 1, start, end, middle)
            System.out.println("盘子 $i 从柱子 $start 移动到柱子 $end ")
            han(i - 1, middle, start, end)
        }
    }


    /**
     * System.out.println(3)
     * System.out.println(2)
     * System.out.println(1)
     * System.out.println(0)
     * System.out.println(-1)
     * //下面的代码先存在代码栈中，当return时，从上往下执行
     * System.out.println(0)
     * System.out.println(1)
     * System.out.println(2)
     * System.out.println(3) 最开始添加的方法
     *
     * 打印结果为：3.2.1.0.-1.0.1.2.3
     */
    private fun tt(i: Int) {
        System.out.println("Test $i")
        if (i < 0) {
            return
        } else {
            tt(i - 1)
            System.out.println("Test $i")
        }
    }

}