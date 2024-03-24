package com.swsm.zcy.bl.playtable;

/**
 * @author liujie
 * @date 2023-06-28
 */
public class MSumToN {
    
    public static boolean isMSum1(int num) {
        for (int i = 0; i <= num; i++) {
            int sum = i;
            for (int j = i + 1; j <= num; j++) {
                if (sum + j > num) {
                    break;
                }
                if (sum + j == num) {
                    return true;
                }
                sum += j;
            }
        }
        return false;
    }
    
    public static boolean isMSum2(int num) {
        if (num < 3) {
            return false;
        }
        // num是不是2的某次方 (num & (num - 1)) = 0，  2的某次方 2进制时只有1个1
        return (num & (num - 1)) != 0;
    }
    
    
}
