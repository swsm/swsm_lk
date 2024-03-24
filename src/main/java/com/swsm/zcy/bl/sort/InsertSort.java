package com.swsm.zcy.bl.sort;

import java.util.Arrays;

/**
 * 插入排序  最好 [1 2 3 4 5 6] O(n) 最差 [6 5 4 3 2 1] O(n^2) 所以时间复杂度为：O(n^2)
 * 逻辑：
 * 1. 先看 0-0位置上是否有序，这个天然有序
 * 2. 再看 0-1位置上是否有序，如果0>1则0和1交换
 * 3. 再看 0-2位置上是否有序，如果1>2则2和1交换，如果交换后0>1则0和1再交换  这样达到局部有序
 * 4. 依次做到 0-n是否有序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 1, 9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    continue;
                } 
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
