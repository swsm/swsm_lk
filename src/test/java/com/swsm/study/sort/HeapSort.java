package com.swsm.study.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2023-06-14
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6, 1, 8, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 构造堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        
        while (heapSize > 0) {
            heapify(arr, 0, heapSize--);
            swap(arr, 0, heapSize);
        }
    }
    
    public static void swap(int[] arr, int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }
    
    public static void heapInsert(int[] arr, int index) {
        
    }
    
    public static int heapify(int[] arr, int left, int right) {
        return -1;
    }
    
    
    
    
}
