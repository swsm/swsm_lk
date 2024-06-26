package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-07-12
 */
public class LongestCommonSubSequence {
    
    public static int lcse(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 0; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 0][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int i = 0; i < str2.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], str1[0] == str2[i] ? 1 : 0);
        }
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[str1.length - 1][str2.length - 1];
    }
    
}
