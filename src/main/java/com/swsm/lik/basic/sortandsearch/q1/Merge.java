package com.swsm.lik.basic.sortandsearch.q1;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 * @author liujie
 * @date 2022/12/8
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
        System.out.println("res=" + Arrays.toString(nums1));
    }

    /**
     * 题目说nums1有足够的空间容纳nums2，所以我们可以认为nums1的长度肯定大于nums2。
     * 正常的归并都是从小往大开始，这里我们可以换种思路，从大往小开始
     *
     */
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int end = m + n - 1;
            while (j >= 0) {
                nums1[end--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
            }
        }
    }
    
    static class SolutionMine {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] array = new int[nums1.length];
            int n1Index = 0;
            int n2Index = 0;
            while (true) {
                if (n1Index == m) {
                    // n1已经做完
                    for(;n2Index < n;n2Index++) {
                        array[n1Index + n2Index] = nums2[n2Index];
                    }
                    break;
                } else if (n2Index == n) {
                    // n2已经做完
                    for (;n1Index < m; n1Index++) {
                        array[n1Index + n2Index] = nums1[n1Index];
                    }
                    break;
                }
                if (nums1[n1Index] <= nums2[n2Index]) {
                    array[n1Index + n2Index] = nums1[n1Index];
                    n1Index++;
                } else {
                    array[n1Index + n2Index] = nums2[n2Index];
                    n2Index++;
                }
            }
            for (int i = 0; i < array.length; i++) {
                nums1[i] = array[i];
            }
        }
    }
    
}
