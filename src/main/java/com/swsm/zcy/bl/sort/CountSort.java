package com.swsm.zcy.bl.sort;

/**
 * @author liujie
 * @date 2023-06-15
 */
public class CountSort {

    /**
     * 计数排序，只针对0-200个数据，对数据量有限制   (时间复杂度 O(N)  空间复杂度 O(Max(N)))
     * 逻辑：
     * 1. 找到数组中的最大值 max
     * 2. 初始化一个桶，大小就是max
     * 3. 循环数组，针对桶的序号就是数组数据的桶值加1
     * 4. 从小到大循环桶，当桶的数据大于0时，就将arr位置从0开始赋值为桶的序号个数，
     * 5. 桶循环完，数组也被重新赋值完毕，当前数组就是有序的了
     * @param arr
     */
    // only for  0-200 values
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
    
}
