package com.swsm.lik.basic.array.q4;

/**
 * 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false
 * @author liujie
 * @date 2022/11/28
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7,7};
        boolean res = solution.containsDuplicate(nums);
        System.out.println("res=" + res);
    }

    /**
     * 时间复杂度高 O(N*N)
     * 
     * a. 可以先排序然后再比较
     * b. 使用Set集合来处理每个元素，然后判断是否有重复
     */
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
