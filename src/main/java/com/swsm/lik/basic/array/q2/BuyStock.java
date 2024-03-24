package com.swsm.lik.basic.array.q2;

/**
 * 
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。

 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

 返回 你能获得的 最大 利润

 * @author liujie
 * @date 2022/11/26
 */
public class BuyStock {

    public static void main(String[] args) {
        
        Solution solution = new Solution();
        int[] stocks = {1,2,3,4,5};
        int res = solution.maxProfit(stocks);
        System.out.println("res=" + res);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int res = 0;
            if (prices.length == 0 || prices.length == 1) {
                return res;
            }
            int currentMin = prices[0];

            // 1. 判断 prices[i] 大于 当前最小值
            // 1.1 当前值 - 最小值 的差加上结果作为新的结果
            // 2. 当前值赋值给当前最小值
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > currentMin) {
                    res = res + (prices[i] - currentMin);
                }
                currentMin = prices[i];
            }
            return res;
        }
    }

    static class SolutionOne {
        public int maxProfit(int[] prices) {
            int res = 0;
            if (prices.length == 0 || prices.length == 1) {
                return res;
            }
            int currentMin = prices[0];

            // 1. 判断 prices[i] 大于 当前最小值
            // 1.1 判断i < 数组长度-1 且 prices数组的下一个数 也 小于 当前数
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > currentMin) {
                    if (i < prices.length - 1 && prices[i + 1] < prices[i]) {
                        res = res + (prices[i] - currentMin);
                        currentMin = prices[i + 1];
                        i++;
                    } else if (i == prices.length -1) {
                        res = res + (prices[i] - currentMin);
                    }
                } else {
                    currentMin = prices[i];
                }
            }
            return res;
        }
    }
    
    
}
