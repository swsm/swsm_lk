package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-07-11
 */
public class CoinsWay {
    
    public static int ways(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        
        return process1(arr, 0, aim);
    }
    
    // 可以自由使用arr[index...]之后所有的面值，每一种面值都可以使用任意张
    // 组成rest有多少种方法
    public static int process1(int[] arr, int index, int rest) {
        if (index == arr.length) { // 没有货币可以选择
            return rest == 0 ? 1 : 0;
        }
        // 当前有货币 arr[index]
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process1(arr, index++, rest - zhang * arr[index]);
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] bp = new int[arr.length + 1][aim + 1];
        for (int[] ints : bp) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = -1;
            }
        }
        return process2(arr, 0, aim, bp);
    }

    // 可以自由使用arr[index...]之后所有的面值，每一种面值都可以使用任意张
    // 组成rest有多少种方法
    public static int process2(int[] arr, int index, int rest, int[][] bp) {
        if (bp[index][rest] != -1) {
            return bp[index][rest];
        }
        
        if (index == arr.length) { // 没有货币可以选择
            bp[index][rest] = rest == 0 ? 1 : 0;
            return bp[index][rest];
        }
        // 当前有货币 arr[index]
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process2(arr, index++, rest - zhang * arr[index], bp);
        }
        bp[index][rest] = ways;
        return bp[index][rest];
    }
    
    public static int way3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        
        dp[N][0] = 1; // dp[N][1...aim] = 0  
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest < aim; rest++) {
                int ways = 0;
                for(int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index + 1][rest - zhang * arr[index]];
                }
                dp[index][rest] = ways;
            }
        }
        
        return dp[0][aim];
    }

    public static int way4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        dp[N][0] = 1; // dp[N][1...aim] = 0  
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest < aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }
    
}
 
