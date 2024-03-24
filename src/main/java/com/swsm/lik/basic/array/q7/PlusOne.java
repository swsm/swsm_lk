package com.swsm.lik.basic.array.q7;

import java.util.Arrays;

/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author liujie
 * @date 2022/11/28
 */
public class PlusOne {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {9, 9, 9, 9};
        int[] res = solution.plusOne(nums);
        System.out.println("res=" + Arrays.toString(res));
    }

    static class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i] = digits[i] + 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
    }
    
}
