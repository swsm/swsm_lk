package com.swsm.lik.basic.math.q3;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * 
 * 输入：n = 27
 * 输出：true
 * 
 * 输入：n = 0
 * 输出：false
 * 
 * 输入：n = 45
 * 输出：false
 *
 * @author liujie
 * @date 2022/12/14
 */
public class IsPowerOfThree {

    public static void main(String[] args) {
        int n = 27;
        Solution solution = new Solution();
        boolean res = solution.isPowerOfThree(n);
        System.out.println("res=" + res);
    }
    
    
    static class Solution {

        public boolean isPowerOfThreeCom(int n) {
            return (n > 0 && 1162261467 % n == 0);
        }

        public boolean isPowerOfThree(int n) {
            if (n == 1 || n == 3) {
                return true;
            }
            int temp = 0;
            while (n > 1) {
                temp = n % 3;
                n = n / 3;
                if (n == 3 && temp == 0) {
                    return true;
                } else if (temp != 0 || n < 3) {
                    return false;
                }
            }
            return false;
            
        }
    }
    
}
