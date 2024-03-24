package com.swsm.lik.basic.str.q2;

/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 
 * 输入：x = 123
 * 输出：321
 *
 * @author liujie
 * @date 2022/11/29
 */
public class Reverse {

    public static void main(String[] args) {
        int num = -2147483648;
        Solution solution = new Solution();
        int reverse = solution.reverse(num);
        System.out.println("res=" + reverse);
    }
    
    static class Solution {
        public int reverse(int x) {
            if (x <= -2147483648) {
                return 0;
            }
            long res = 0;
            while (true) {
                res = res * 10 + x % 10;
                int nextVal = x - x % 10;
                if (nextVal == 0) {
                    if (res < -Math.pow(2, 31) || res >= (Math.pow(2, 31) - 1)) {
                        return 0;
                    }
                    return Long.valueOf(res).intValue();
                }
                x = (x - x % 10) / 10;
            }
        }
    }
    
    static class SolutionMine {
        public int reverse(int x) {
            if (x <= -2147483648) {
                return 0;
            }
            boolean isFu = false;
            if (x < 0) {
                isFu = true;
                x = Math.abs(x);
            }

            char[] chars = String.valueOf(x).toCharArray();
            char temp;
            for (int i = 0; i < chars.length / 2; i++) {
                temp = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = temp;
            }
            Long res = Long.valueOf(new String(chars));
            res = isFu ? -res : res;
            if (res < -Math.pow(2, 31) || res >= (Math.pow(2, 31) - 1)) {
                return 0;
            }
            return res.intValue();
        }
    }
    
    static class SolutionMine2 {
        public int reverse(int x) {
            if (x <= -2147483648) {
                return 0;
            }
            boolean isFu = false;
            if (x < 0) {
                isFu = true;
                x = Math.abs(x);
            }
            String str = String.valueOf(x);
            int res = 0;
            for (int i = 0; i < str.length(); i++) {
                res += Integer.valueOf("0" + str.charAt(i)) * (Math.pow(10, i)); 
            }
            if (res < -Math.pow(2, 31) || res >= (Math.pow(2, 31) - 1)) {
                return 0;
            }
            return isFu ? -res : res;
        }
    }
    
}
