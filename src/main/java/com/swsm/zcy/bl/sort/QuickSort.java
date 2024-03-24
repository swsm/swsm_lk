package com.swsm.zcy.bl.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2023-06-15
 */
public class QuickSort {

    /**
     * 快速排序(时间复杂度 O(NlogN) 空间复杂度 O(logN) 稳定性：否)
     * 逻辑：
     * 1. 当arr为空或者arr长度小于2则直接返回
     * 2. 递归函数开始，baseCase为 L>=R就结束
     * 3. 从数组中随机挑选一个数和数组最后的数交换
     * 4. 对数组L-R进行荷兰国旗处理，得到与R相等的数组下标 equalArea[2]
     * 5. 递归处理L 到 equalArea[0]-1
     * 6. 递归处理 equalArea[1]+1 到 R
     */
    public static void quickSore3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
        int[] equalArea = partition2(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }

    /**
     * 将arr中，L 和 R位置的数排列成，比R小的在左边，跟R一样的在中间，比R大的在右边
     * 犹如 荷兰国旗
     */
    public static int[] partition2(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        } else if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 8, 1, 4, 2, 0, 9};
        quickSore3(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
