package com.swsm.lik.basic.dynamicplanning.q1;

/**
 * 爬楼梯
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 
 * @author liujie
 * @date 2022/12/8
 */
public class ClimbStairs {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.climbStairs(45);
        System.out.println("res=" + res);
    }
    

    static class Solution {

        /**
         * 尾递归的方式
         * @param n
         * @return
         */
        public static int climbStairsCom(int n) {
            return Fibonacci(n, 1, 1);
        }

        public static int Fibonacci(int n, int a, int b) {
            if (n <= 1)
                return b;
            return Fibonacci(n - 1, b, a + b);
        }
        
        public int climbStairs(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int i = 3;
            int lastLast = 1;
            int last = 2;
            int now = 0;
            while (i <= n) {
                now = last + lastLast;
                lastLast = last;
                last = now;
                i++;
            }
            return now;
        }
        
        public int climbStairsRecurious(int n) {
            if (n == 1) {
                return 1;
            } else if (n == 0) {
                return 0;
            } else if (n == 2) {
                return 2;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
    
}
