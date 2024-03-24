package com.swsm.zcy.bl.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2023-06-14
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 8, 1, 4, 2, 0, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序  (时间复杂度 O(NLogN) 空间复杂度 O(1) 稳定性：无)
     * 逻辑：
     * 1. 将数组构建成堆结构
     * 2. 数组的长度作为堆的长度
     * 3. 交换数组的第一个位置和最后一个位置：即把最大数放到数组的最后一个位置，heapSize--
     * 4. 执行数组长度次数，先从heapSize开始，
     * 5. 在0-heapSize调整大根堆
     * 6. 交换 0和heapSize-1位置的数：即把最大数放到数组的倒数第二个位置，heapSize--
     * 9. 循环5
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 建堆  O(N*logN)
//        for (int i = 0; i < arr.length; i++) {  // O(N)
//            heapInsert(arr, i);   // O(logN)
//        }
        
        // 优化建堆 O(N)
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 调整堆为大根堆
     * 从index位置开始往下看，不断下沉，我的子节点都不比我大，就停，
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 左右两个子节点中，谁大谁将下标给 largest
            int largest = (left + 1 < heapSize && arr[left + 1] > arr[left]) ? left + 1 : left;
            // 临时父节点和最大节点谁大 谁给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}
