package com.swsm.zcy.bl.greedy;

import java.util.PriorityQueue;

/**
 * @author liujie
 * @date 2023-07-01
 */
public class LessMoney {
    
    public static int lessMoney1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return process(arr, 0);
    }
    
    public static int process(int[] arr, int pre) {
        if (arr.length == 1) {
            return pre;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 后面的 pre + arr[i] + j 可能不对
                ans = Math.min(ans, process(copyAndMergeTwo(arr, i, j), pre + arr[i] + j));
            }
        }
        return ans;
    }
    
    public static int[] copyAndMergeTwo(int[] arr, int i, int j) {
        int[] ans = new int[arr.length - 1];
        int ansi = 0;
        for (int arri = 0; arri < arr.length; arri++) {
            if (arri != i && arri != j) {
                ans[ansi++] = arr[arri];
            }
        }
        ans[ansi] = arr[i] + arr[j];
        return ans;
    }
    
    

    /**
     * 分割金条
     * 逻辑：
     * 1. 小根堆将数据都放里面
     * 2. 每次弹两个加起来再放进小根堆，直到队列中只有一个
     * 3. 则所有非叶子节点之和 就是最后的总花费
     */
    public static int lessMoney2(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pq.size() > 1) {
            cur = pq.poll() + pq.poll();
            sum += cur;
            pq.add(cur);
        }
        return sum;
    }
    
    
}
