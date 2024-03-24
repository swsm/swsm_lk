package com.swsm.lik.basic.dynamicplanning.q3.q4;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author liujie
 * @date 2022/12/13
 */
public class Rob {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        Solution solution = new Solution();
        int res = solution.rob(nums);
        System.out.println("res=" + res);
    }

    /**
     * 动态规划
     * 1. 确定状态
     * 2. 确定状态转移公式
     * 3. 确定终止条件和边界
     * 4. 计算结果
     * 
     * 确定状态：dp[i][0] 表示第i+1家没有偷 dp[i][1]表示第i+1家被偷了
     * 确定状态转移公式：如果第i+1家没有偷 dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]),如果第i+1家被偷了 dp[i][1] = dp[i-1][0] + nums[i]
     * 
     */
    static class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            int lastRob = nums[0];
            int lastNotRob = 0;
            int temp = 0;
            int res = Math.max(lastNotRob, lastRob);
            for (int i = 1; i < length; i++) {
                temp = Math.max(lastNotRob, lastRob);
                lastRob = lastNotRob + nums[i];
                lastNotRob = temp;
                res = Math.max(lastNotRob, lastRob);
            }
            return res;
        }
    }
    
}
