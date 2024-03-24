package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-07-11
 */
public class Queen {
    
    public static int main1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    /**
     * 在 i行上要放皇后
     * @param i  i行
     * @param record  0 - i-1行 已经放的皇后存储的位置
     * @param n 一共有多少行
     * @return
     */
    public static int process1(int i, int[] record, int n) {
        if (i == n) { // 终止行
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    
    public static int main2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    /**
     * 
     * @param limit  每行的限制，刚开始都是1  位上1表示不能放 0表示能放
     * @param colLim  列限制
     * @param leftDiaLim 左斜线限制
     * @param rightDiaLim 右斜线限制
     */
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {  // 列已经都点满皇后，表示ok base case
            return 1;
        }
        // colLim | leftDiaLim | rightDiaLim  总限制
        // ~(colLim | leftDiaLim | rightDiaLim)  左侧的一堆0干扰，右侧每个1可尝试
        // 1 可摆  0不能摆   所有可以选择的位置都在pos上
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            // 提取出 pos中最右侧的1
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
    
    
}
