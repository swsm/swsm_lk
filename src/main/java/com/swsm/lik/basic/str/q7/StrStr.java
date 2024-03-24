package com.swsm.lik.basic.str.q7;

/**
 * 实现 strStr()
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 最快为kmp算法实现
 * @author liujie
 * @date 2022/12/1
 */
public class StrStr {

    public static void main(String[] args) {
        String haystack = "s1adbutsad";
        String needle = "sad";
        Solution solution = new Solution();
        int res = solution.strStr(haystack, needle);
        System.out.println("res=" + res);
    }

    static class Solution {
        
        public int strStr(String haystack, String needle) {
            int oneStart = 0;
            int step = 0;
            while (oneStart + needle.length() <= haystack.length()) {
                if (step == needle.length()) {
                    return oneStart;
                }
                if (haystack.charAt(oneStart + step) == needle.charAt(step)) {
                    step++;
                } else {
                    oneStart++;
                    step = 0;
                }
            }
            return -1;
        }
    }
    
}
