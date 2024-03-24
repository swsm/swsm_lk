package com.swsm.zcy.bl.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2023-06-11
 */
public class MergeSort {

    /**
     * 递归实现归并排序(时间复杂度: O(NlogN), 空间复杂度 O(N), 稳定性：是)
     * 逻辑：
     * 1. 数组为null 或者 数组长度小于2 则直接返回
     * 2. 开始递归处理数组，在0 到 arr.length - 1的区间内
     * 3. base条件，如果 L == R则退出递归
     * 4. 计算中间节点 mid = L + (R >> 1) / 2
     * 5. 递归处理 L到mid
     * 6. 递归处理 mid+1 到 R
     * 7. 对L到R的中间以mid为分界的数组进行合并排序成有序数组(创建一个临时数组，2个指针分别指向两个数组的起始位置，判断大小后，小的放入临时数组指针向前移动...)
     */
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    /**
     * 非递归方式 实现归并排序
     * 逻辑：
     * 1. arr为null或者arr的length小于2则退出
     * 2. 定义mergeSize变量，从1开始后面每次乘2，开始循环
     * 3. 每次从头将mergeSize*2的个数进行merge排序达到局部有序，比如一共9个数，则mergeSize=1时0-1 2-3 4-5 6-7 8
     * 4. 下次就是mergeSize=2时, 0-3 4-7 8
     * 5. 下次就是mergeSize=4时, 0-7 8
     * 6. 下次就是mergeSize=8时, 0-8 完成排序
     */
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        int mergeSize = 1; // 当前有序的左组长度
        while (mergeSize < n) {
            int l = 0;
            while (l < n) {
                int m = l + mergeSize - 1;
                if (m >= n) {
                    break;
                }
                int r = Math.min(m + mergeSize, n - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
            // 防止溢出
            if (mergeSize > n / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 8, 1, 4, 2, 0, 9};
        mergeSort1(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {3, 6, 4, 8, 1, 4, 2, 0, 9};
        mergeSort2(arr2);
        System.out.println(Arrays.toString(arr));
    }
    
}
