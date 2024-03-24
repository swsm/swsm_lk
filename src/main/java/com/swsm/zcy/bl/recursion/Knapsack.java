package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-07-10
 */
public class Knapsack {
    
    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, 0, bag);
    }

    /**
     * 获取index...往后的价值总量
     * 
     * @param w   重量数组(不变)
     * @param v   价值数组(不变)
     * @param index  当前序号
     * @param alreadyW  已经形成的重量
     * @param bag    袋子的承受重量(不变)
     * @return  -1没有价值 无效  >1真实的价值
     */
    public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        if (alreadyW > bag) {
            return -1;
        }
        // 重量没超
        if (index == w.length) {
            return 0;
        }
        int p1 = process(w, v, index + 1, alreadyW, bag);
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2next != -1) {
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);
    }
    
    public static int maxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    /**
     * 只剩下rest的空间了
     * index...货物自有选择，但是剩余空间不要小于0
     * 返回index...货物能够获得的最大价值
     */
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest <= 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        // 有货也有空间
        // 当前index 不要放进来
        int p1 = process(w, v, index + 1, rest);
        int p2 = -1;
        int p2Next = process(w, v, index + 1, rest - w[index]);
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }
    
    public static int dpWay(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if (rest >= w[index]) {
                    p2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }
    
    
}
