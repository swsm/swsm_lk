package com.swsm.lik.basic.array.q9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * 
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 *
 * @author liujie
 * @date 2022/11/29
 */
public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,3};
        int[] res = solution.twoSum(nums, 6);
        System.out.println("res=" + Arrays.toString(res));
    }
    
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }

    static class SolutionMapOne {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + "," + i);
                } else {
                    map.put(nums[i], i + "");
                }
            }
            for (Integer val : map.keySet()) {
                int other = target - val;
                if (map.containsKey(other) && other != val) {
                    return new int[]{Integer.valueOf(map.get(val).split(",")[0]), Integer.valueOf(map.get(other).split(",")[0])};
                } else if (other == val && map.get(val).contains(",")) {
                    return new int[]{Integer.valueOf(map.get(val).split(",")[0]), Integer.valueOf(map.get(val).split(",")[1])};
                }
            }
            return null;
        }
    }

    /**
     * O(n2) 时间复杂度
     */
    static class SolutionMine {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }
    
    
}
