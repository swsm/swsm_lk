package com.swsm.lik.basic.array.q3;

import java.util.Arrays;

/**
 * 旋转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * @author liujie
 * @date 2022/11/27
 */
public class RotateArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate(nums, 3);
        System.out.println("res=" + Arrays.toString(nums));
    }

    /**
     * todo： 为什么旋转 能用翻转来解决？？？
     * 翻转实现
     * 先翻转全部
     * 再翻转前 k % length个
     * 再翻转剩余元素
     */
    static class Solution {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            if (length == 0 || length == 1) {
                return;
            }
            int pos = k % length;
            if (pos == 0) return;
            
            // 先翻转全部
            for (int i = 0; i < length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[length - i - 1];
                nums[length - i - 1] = temp;
            }
            // 再翻转 前k % length个
            for (int i = 0; i < pos / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[pos - i - 1];
                nums[pos - i - 1] = temp;
            }
            
            // 再翻转剩余元素
            for (int i = 0; i < (length - pos) / 2; i++) {
                int temp = nums[i + pos];
                nums[i + pos] = nums[length - i - 1];
                nums[length - i - 1] = temp;
            }
            
        }
    }

    static class SolutionMin {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            if (length == 0 || length == 1) {
                return;
            }
            int pos = k % length;
            if (pos == 0) return;
            int changeIndex = 0;
            int changeIndexValue = nums[0];
            boolean[] visited = new boolean[length];
            for (int i = 0; i < length; i++) {
                int nextChangeIndex = (changeIndex + pos) % length;
                if (visited[changeIndex]) {
                    changeIndex++;
                    changeIndexValue = nums[changeIndex];
                    i--;
                } else {
                    visited[changeIndex] = true;
                    int temp = nums[nextChangeIndex];
                    nums[nextChangeIndex] = changeIndexValue;
                    changeIndexValue = temp;
                    changeIndex = nextChangeIndex;
                }
                
            }
        }
        
        
    }
    
}



