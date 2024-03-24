package com.swsm.lik.basic.math.q2;

/**
 * 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * 
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 输入：n = 0
 * 输出：0
 * 
 * 输入：n = 1
 * 输出：0
 * 
 * @author liujie
 * @date 2022/12/14
 */
public class CountPrimes {

    public static void main(String[] args) {
        int n = 5000000;
        Solution solution = new Solution();
        int res = solution.countPrimes(n);
        System.out.println("res=" + res);
    }

    /**
     * 艾拉托斯特尼筛法，简称艾氏筛，或者素数筛。
     * 原理：从2开始，将每个素数的各个倍数，标记成合数，一个素数的各个倍数是一个差为此素数本身的等差数列。
     * 此为这个筛法和试除法不同的关键之处，后者是以素数来测试每个待测数能否被整除
     */
    static class Solution {
        public int countPrimes(int n) {
            boolean[] arr = new boolean[n];
            int cnt = 0;
            for(int i = 2; i < n; i++) {
                if(arr[i]) continue;
                cnt++;
                for(int j = i; j < n; j+=i) {
                    arr[j] = true;
                }
            }
            return cnt;
        }

    }
    
}
