package com.swsm.zcy.bl.sort;

import java.util.Arrays;

/**
 * 冒泡排序 O(n^2)
 * 逻辑：
 * 1. 第一个数和第二个数比大小，大的在后面
 * 2. 第二个数和第三个数比大小，大的在后面
 * 3. 依次比较到最后一个数，则最大的数就在最后面了
 * 4. 第一个数继续和第二个数比大小，大的在后面
 * 5. 一直比较到倒数第二个数，则第二大的数就在倒数第二的位置了
 * 6. 最终所有数组变成从小到大排序的
 * 
 * @author liujie
 * @date 2023-06-08
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 1, 0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
