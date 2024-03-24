package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-06-11
 */
public class GetMax {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int res = process(arr, 0, arr.length - 1);
        System.out.println(res);
    }

    /**
     * 递归 二分查找返回数组中的最大值  时间复杂度为O(N)
     * 逻辑:
     * 1. 当只有一个位置时返回当前值
     * 2. 计算中间值 (l + ((r - l) >> 1))
     * 3. 调用自己计算左边最大值 
     * 4. 调用自己计算右边最大值
     * 5. 比较左边右边最大值并返回
     */
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
    
}
