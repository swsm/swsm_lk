package com.swsm.lik.basic.dynamicplanning.q3;

/**
 * 最大子序和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 
 * 输入：nums = [1]
 * 输出：1
 * 
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * @author liujie
 * @date 2022/12/13
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        Solution solution = new Solution();
        int res = solution.maxSubArray(nums);
        System.out.println("res=" + res);
    }


    /**
     * 动态规划
     * 1. 确定状态
     * 2. 找到状态转移表达式
     * 3. 确定初始条件及边界
     * 4. 计算结果
     * 
     * 确定状态：dp[i] 表示 右节点为i节点的最大子序值
     * 找到状态转移表达式：dp[i-1] < 0, dp[i] = nums[i],否则，dp[i] = dp[i-1] + nums[i]
     * 确定初始条件及边界：dp[0] = nums[0],边界i<nums.length
     */
    static class Solution {
        
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            int cur = nums[0];
            int max = cur;
            for (int i = 1; i < length; i++) {
                cur = Math.max(cur, 0) + nums[i];
                //记录最大值
                max = Math.max(max, cur);
            }
            return max;
        }
        
        public int maxSubArrayMine(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], 0) + nums[i];
                res = Math.max(dp[i], res);
            }
            return res;
        }
        
    }
    
}
