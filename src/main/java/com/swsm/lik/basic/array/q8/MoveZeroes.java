package com.swsm.lik.basic.array.q8;

import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2ba4i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author liujie
 * @date 2022/11/28
 */
public class MoveZeroes {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println("res=" + Arrays.toString(nums));
    }
    
    static class Solution {
        public void moveZeroes(int[] nums) {
            int setIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[setIndex] = nums[i];
                    setIndex++;
                } 
            }
            for (int i = 0; i < nums.length - setIndex; i++) {
                nums[nums.length - i - 1] = 0; 
            }
        }
    }
    
    static class SolutionMine {
        public void moveZeroes(int[] nums) {
            int zeroIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0 && zeroIndex == -1) {
                    zeroIndex = i;
                } else if (nums[i] != 0 && zeroIndex != -1){
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                    if (nums[zeroIndex + 1] == 0) {
                        zeroIndex++;
                    } else {
                        zeroIndex = i;
                    }
                }
            }
        }
    }
    
}
