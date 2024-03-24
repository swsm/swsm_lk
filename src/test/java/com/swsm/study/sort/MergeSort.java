package com.swsm.study.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2023-06-14
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6, 1, 8, 7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void mergeSort(int[] arr) {
        if (arr == null | arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    
    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int left = L;
        int right = mid + 1;
        
        int index = 0;
        while (left <= mid && right <= R) {
            help[index++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        while (left <= mid) {
            help[index++] = arr[left++];
        }
        while (right <= R) {
            help[index++] = arr[right++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
    
    
}
