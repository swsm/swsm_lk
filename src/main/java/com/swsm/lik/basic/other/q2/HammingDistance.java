package com.swsm.lik.basic.other.q2;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * 
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 示例 2：
 *
 * 输入：x = 3, y = 1
 * 输出：1
 * 
 * @author liujie
 * @date 2023-01-10
 */
public class HammingDistance {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.hammingDistance(1, 11);
        System.out.println("res=" + res);
    }
    
    
    static class Solution {
        public int hammingDistance(int x, int y) {
            int newValue = x ^ y;
            return Integer.bitCount(newValue);
        }
    }
    
}
