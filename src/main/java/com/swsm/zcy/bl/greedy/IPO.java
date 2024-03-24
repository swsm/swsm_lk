package com.swsm.zcy.bl.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liujie
 * @date 2023-07-02
 */
public class IPO {
    
    public static class Program {
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    
    public static class MinCostComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }
    }
    
    public static class MaxProfitCompartor implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }

    /**
     * 投资项目最大收益
     * 逻辑:
     * 1. 最小花费创建小根堆，最大收益创建大根堆
     * 2. 依次加入所有数据到 最小花费队列，
     * 3. 循环K次
     * 4. 如果最小花费队列不为空 且 最小花费的最小值 小于等于 W，就将数据放到最大收益队列
     * 5. 如果最大收益队列为空则返回当前已计算最大收益
     * 6. 最大收益 += 最大收益队列取出的值
     * 7. 循环3操作
     */
    public static int findMaximizedCapital(int K, int W, int[] profits, int[] capital) {
        PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitCompartor());
        for (int i = 0; i < profits.length; i++) {
            minCostQ.add(new Program(profits[i], capital[i]));
        }
        for (int i = 0; i < K; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
    
    
}
