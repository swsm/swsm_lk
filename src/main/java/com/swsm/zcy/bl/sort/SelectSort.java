package com.swsm.zcy.bl.sort;


import java.util.Arrays;

/**
 * 选择排序   O(n^2)
 * 逻辑：
 * 1. 选择数组中最小的数和第一个位置数交换
 * 2. 再从第2个位置开始到最后选择最小的数和第二个位置数交换
 * 3. 依次进行到最后一个数则完成排序
 * 
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 1, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void selectSort(int[] arr) {
        
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                minPosition = arr[i] <= arr[j] ? i : j;
            }
            swap( arr, i, minPosition);
        }
        
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
}
