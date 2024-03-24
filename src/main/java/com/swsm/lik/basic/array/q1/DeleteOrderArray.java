package com.swsm.lik.basic.array.q1;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author liujie
 * @date 2022/11/25
 */
public class DeleteOrderArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 1, 2, 2, 3, 4, 5, 5};
        int res = solution.removeDuplicates(nums);
        System.out.println("res=" + res);
        System.out.println("nums=" + Arrays.toString(nums));
    }

    static class Solution {

        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int leftIndex = 0;
            for (int rightIndex = 1; rightIndex < nums.length; rightIndex++) {
                if (nums[leftIndex] != nums[rightIndex]) {
                    leftIndex++;
                    nums[leftIndex] = nums[rightIndex];
                } 
            }
            leftIndex++;
            return leftIndex;
        }
        
        public int removeDuplicatesMine(int[] nums) {
            int duplicateNum = 0;
            Integer currentNum = null;
            int setIndex = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                currentNum = currentNum == null ? nums[i] : currentNum;
                if (currentNum == nums[i + 1]) {
                    duplicateNum++;
                    setIndex = setIndex == -1 ? i + 1 : setIndex;
                } else {
                    currentNum = nums[i + 1];
                    if (setIndex != -1) {
                        nums[setIndex] = nums[i + 1];
                        currentNum = nums[setIndex];
                        setIndex++;
                    }
                }
            }
            return nums.length - duplicateNum;
        }
    }
}
