package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-07-12
 */
public class Coffee {
    
//    public static int minTime1(int[] arr, int n, int a, int b) {
//        int[] times = new int[arr.length];
//        int[] drink = new int[n];
//        return forceMake(arr, times, 0, drink, n, a, b);
//    }
//    
//    public static int forceMake(int[] arr, int[] times, int kth, int[] drink, int n, int a, int b) {
//        if (kth == n) {
//            int[] drinkSorted = Arrays.copyOf(drink, kth);
//            Arrays.sort(drinkSorted);
//            return forceWash(drinkSorted, a, b, 0, 0, 0);
//        }
//        int time = Integer.MAX_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            int work = arr[i];
//            int pre = times[i];
//            drink[kth] = pre + work;
//            times[i] = pre + work;
//            
//        }
//    }

    /**
     * drinks[index...]都想变干净，最少时间点返回
     * 
     * @param drinks  每个员工喝完的时间   固定变量
     * @param a  洗一杯的时间， 固定变量
     * @param b  自己挥发干净的时间，固定变量
     * @param index   drinks[0..index-1]的咖啡杯已经干净了
     * @param washLine   表示洗的机器何时可用  
     * @return
     */
    public static int process(int[] drinks, int a, int b, int index, int washLine) {
        if (index == drinks.length - 1) {
            // 就剩最后一杯咖啡了
            return Math.min(Math.max(washLine, drinks[index]) + a, drinks[index] + b);
        }
        // 剩不止一杯咖啡
        // wash是我当前的咖啡杯，洗完的时间
        int wash = Math.max(washLine, drinks[index]) + a;
        // index+1 ... 变干净的最少时间
        int next1 = process(drinks, a, b, index + 1, wash);
        int p1 = Math.max(wash, next1);
        
        // 当前的咖啡杯， 挥发
        int dry = drinks[index] + b;
        int next2 = process(drinks, a, b, index + 1, washLine);
        int p2 = Math.max(dry, next2);
        
        return Math.min(p1, p2);
    }
    
    
    public static int dp(int[] drinks, int a, int b) {
        if (a >= b) {
            return drinks[drinks.length - 1] + b;
        }
        int N = drinks.length;
        int limit = 0;
        for (int i = 0; i < N; i++) {
            limit = Math.max(limit, drinks[i] + a);
        }
        int[][] dp = new int[N][limit + 1];
        for (int washLine = 0; washLine <= limit; washLine++) {
            dp[N - 1][washLine] = Math.min(Math.max(washLine, drinks[N - 1]) + a, drinks[N - 1] + b);
        }
        for (int index = N - 1; index > 0; index--) {
            for (int washLine = 0; washLine <= limit; washLine++) {
                int wash = Math.max(washLine, drinks[index]) + a;
                int p1 = Integer.MAX_VALUE;
                if (wash <= limit) {
                    p1 = Math.max(wash, dp[index + 1][wash]);
                }
                int p2 = Math.max(drinks[index] + b, dp[index + 1][washLine]);
                dp[index][washLine] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }
    
    
    
    
}
