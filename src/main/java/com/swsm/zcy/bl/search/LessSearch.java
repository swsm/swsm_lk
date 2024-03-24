package com.swsm.zcy.bl.search;

/**
 * 求局部最小（一个值既小于左边的值又小于右边的值）  也是用二分法
 * 
 * @author liujie
 * @date 2023-06-10
 */
public class LessSearch {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 5, 6, 5, 5};
        int res = getLessIndex(arr);
        System.out.println(res);
    }

    /**
     * 找局部最小的小标(既小于左边值，又小于右边值 也是二分查找的一种变体，时间复杂度：logN) 
     * 逻辑：
     * 1. 边界问题先处理：0个或1个元素返回-1，2个元素且0号位小于1号位返回0，倒数第二元素大于倒数第一元素返回倒数第一元素下标
     * 2. 因为上面已经去掉了边界情况，所以left从1开始，right从arr.length-2开始
     * 3. 当left 小于等于 right，计算mid = left + (right >> 1) / 2,
     * 4. 如果mid > mid-1的值，则right = mid - 1 继续循环3
     * 5. 如果mid > mid+1的值，则left = mid + 1 继续循环3
     * 6. 否则返回mid
     * 7. 当left > right时，返回left下标
     */
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return -1;
        }
        if (arr.length == 2 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left <= right) {
            mid = left + (right >> 1) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;   
    }
}
