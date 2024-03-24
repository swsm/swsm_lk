package com.swsm.lik.basic.design.q1;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * 
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 * 
 * @author liujie
 * @date 2022/12/13
 */
public class Shuffle {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        int[] shuffle = solution.shuffle();
        System.out.println("shuffle=" + Arrays.toString(shuffle));
        solution.reset();
        System.out.println("reset=" + Arrays.toString(solution.nums));
    }
    

    static class Solution {
        
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle() {
            int[] newNums = Arrays.copyOf(nums, nums.length);
            Random random = new Random();
            int randomIndex;
            int temp;
            for (int i = 0; i < nums.length; i++) {
                randomIndex = random.nextInt(nums.length);
                temp = newNums[randomIndex];
                newNums[randomIndex] = newNums[i];
                newNums[i] = temp;
            }
            return newNums;
        }
    }
    
}
