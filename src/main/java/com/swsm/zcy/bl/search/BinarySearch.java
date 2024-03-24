package com.swsm.zcy.bl.search;

/**
 * 二分法查找   O(logN)  因为最后查找的次数为 看 N趋近于2的几次方 就是最多查找的次数所以就是log2^N
 * 
 * @author liujie
 * @date 2023-06-08
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        int position = binarySearchGood(arr, 7);
        System.out.println(position);
    }
    
    public static int binarySearch(int[] arr, int val) {
        int midPosition = arr.length / 2;
        while (midPosition > 0 && midPosition < arr.length - 1) {
            if (arr[midPosition] == val) {
                return midPosition;
            } else if (arr[midPosition] < val) {
                midPosition = midPosition + (arr.length - midPosition) / 2;
            } else {
                midPosition = midPosition / 2;
            }
        }
        if (arr[midPosition] == val) {
            return midPosition;
        } 
        return -1;
    }

    /**
     * 二分查找(logN)
     * 逻辑：
     * 1. 左边界为0，右边界为数组长度-1
     * 2. 当左边界小于等于右边界
     * 3. 计算中间位置 mid = l + (r >> 1) / 2
     * 4. 如果中间位置比目标值小，则l = mid + 1，继续循环2
     * 5. 如果中间位置比目标值大，则r = mid - 1,继续循环2
     * 6. 如果中间位置和目标相等则返回当前下标，命中结果
     * 7. 如果 出现左边界大于右边界则表示 目标不在数组中，返回-1
     */
    public static int binarySearchGood(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= val) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;

    }
    
    
}
