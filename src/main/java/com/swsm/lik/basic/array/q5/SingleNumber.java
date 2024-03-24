package com.swsm.lik.basic.array.q5;

/**
 * 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x21ib6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author liujie
 * @date 2022/11/28
 */
public class SingleNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,4,4,-1,7,7};
        int res = solution.singleNumber(nums);
        System.out.println("res=" + res);
    }

    /**
     * 使用 异或 运算
     */
    static class Solution {
        public int singleNumber(int[] nums) {
            int reduce = 0;
            for (int num : nums) {
                reduce =  reduce ^ num;
            }
            return reduce;
        }
    }
}
