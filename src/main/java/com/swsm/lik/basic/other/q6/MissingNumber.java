package com.swsm.lik.basic.other.q6;

import java.util.Arrays;

/**给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

  

 示例 1：

 输入：nums = [3,0,1]
 输出：2
 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 示例 2：

 输入：nums = [0,1]
 输出：2
 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 示例 3：

 输入：nums = [9,6,4,2,3,5,7,0,1]
 输出：8
 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 示例 4：

 输入：nums = [0]
 输出：1
 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
  

 提示：

 n == nums.length
 1 <= n <= 104
 0 <= nums[i] <= n
 nums 中的所有数字都 独一无二
  

 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?

 * @author liujie
 * @date 2023-01-10
 */
public class MissingNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0};
        int res = solution.missingNumber(nums);
        System.out.println("res=" + res);
    }
    
    
    static class Solution {

        /**
         * 求和来解决
         * @param nums
         * @return
         */
        public int missingNumberSum(int[] nums) {
            int length = nums.length;
            int sum = (0 + length) * (length + 1) / 2;
            for (int i = 0; i < length; i++)
                sum -= nums[i];
            return sum;
        }


        /**
         * 异或来解决
         * @param nums
         * @return
         */
        public int missingNumber(int[] nums) {
            int xor = 0;
            for (int i = 0; i < nums.length; i++)
                xor ^= nums[i] ^ i;
            return xor ^ nums.length;
        }
        
        public int missingNumberMe(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return nums.length;
        }
    }
    
}
