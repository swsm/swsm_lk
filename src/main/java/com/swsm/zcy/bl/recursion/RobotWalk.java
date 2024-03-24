package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-07-11
 */
public class RobotWalk {
    
    public static int ways1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }

    /**
     * 只能在1-N位置上移动，当前在cur位置，走完rest步之后停在p位置的方法数
     * @param N  位置为1-N 固定参数
     * @param cur 当前在cur位置，可变参数
     * @param rest 还剩rest步没走，可变参数
     * @param p 最终目标位置p，固定参数
     */
    public static int walk(int N, int cur, int rest, int p) {
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }
        if (cur == 1) {
            return walk(N, 2, rest - 1, p);
        }
        if (cur == N) {
            return walk(N, N - 1, rest - 1, p);
        }
        return walk(N, cur + 1, rest - 1, p) + walk(N, cur - 1, rest - 1, p);
    }


    public static int walk2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int row = 0; row <= N; row++) {
            for (int col = 0; col <= K; col++) {
                dp[row][col] = -1;
            }
        }
        
        return walkCache(N, M, K, P, dp);
    }


    /**
     * 只能在1-N位置上移动，当前在cur位置，走完rest步之后停在p位置的方法数
     * @param N  位置为1-N 固定参数
     * @param cur 当前在cur位置，可变参数
     * @param rest 还剩rest步没走，可变参数
     * @param p 最终目标位置p，固定参数
     */
    public static int walkCache(int N, int cur, int rest, int p, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == p ? 1 : 0;
            return dp[cur][rest];
        }
        if (cur == 1) {
            dp[cur][rest] = walkCache(N, 2, rest - 1, p, dp);
            return dp[cur][rest];
        }
        if (cur == N) {
            dp[cur][rest] = walkCache(N, N - 1, rest - 1, p, dp);
            return dp[cur][rest];
        }
        dp[cur][rest] = walkCache(N, cur + 1, rest - 1, p, dp) + walkCache(N, cur - 1, rest - 1, p, dp);
        return dp[cur][rest];
    }
    
}
