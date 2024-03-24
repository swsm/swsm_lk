package com.swsm.zcy.bl.recursion;

import java.util.ArrayList;

/**
 * @author liujie
 * @date 2023-07-07
 */
public class Permutations {
    
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    /**
     * str[0..i-1]已经做好决定了
     * str[i...]i往后的所有字符都有机会来到i位置
     * i如果在终止位置则结束
     */
    public static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
        }
        // 如果i没有终止，i... 都可以来到i位置
        // j i后面所有的字符都有机会
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            process(str, i + 1, res);
            // 恢复现场
            swap(str, i, j);
        }
    }
    
    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    
    
    public static ArrayList<String> permutationNoRepeat(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process2(chs, 0, res);
        return res;
    }
    
    public static void process2(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];   // visit [0 1 ... 25] 
        for (int j = i; j < str.length; j++) {
            // str[j] = 'a' -> 0  visit[0] -> 'a'
            // str[j] = 'z' -> 25  visit[25] -> 'a'
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true; 
                swap(str, i + 1, j);
                process2(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }
    
    
    
}
