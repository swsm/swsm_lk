package com.swsm.lik.basic.array.q6;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 
 * @author liujie
 * @date 2022/11/28
 */
public class Intersect {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,1,4,4,-1,7,7};
        int[] nums2 = {1, 1, 7,7};
        int[] res = solution.intersect(nums1, nums2);
        System.out.println("res=" + Arrays.toString(res));
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int[] res = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
            int nums1Index = 0;
            int nums2Index = 0;
            if (nums1[nums1.length - 1] < nums2[0] || nums2[nums2.length - 1] < nums1[0]) {
                return new int[0];
            }
            int index = 0;
            while (nums1Index < nums1.length && nums2Index < nums2.length) {
                if (nums1[nums1Index] == nums2[nums2Index]) {
                    res[index] = nums1[nums1Index];
                    index++;
                    nums1Index++;
                    nums2Index++;
                } else if (nums1[nums1Index] < nums2[nums2Index]) {
                    nums1Index++;
                } else {
                    nums2Index++;
                }
            }
            return Arrays.copyOf(res, index);
        }
    }
    
}
