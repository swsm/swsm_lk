package com.swsm.lik.basic.str.q9;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author liujie
 * @date 2022/12/4
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {""};
        Solution solution = new Solution();
        String res = solution.longestCommonPrefix(strs);
        System.out.println("res=" + res);
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            char prefix = ' ';
            int sameCount = 0;
            String samePrefix = "";
            for (int index = 0; index < strs[0].length() ; index++) {
                prefix = strs[0].charAt(index);
                for (int i = 0; i < strs.length && index < strs[i].length(); i++) {
                    if (prefix == strs[i].charAt(index)) {
                        sameCount++;
                    }
                }
                if (sameCount == strs.length) {
                    samePrefix = strs[0].substring(0, index + 1);
                } else {
                    return samePrefix;
                }
                sameCount = 0;
            }
            return samePrefix;
        }

    }

    static class SolutionPlus {
        public String longestCommonPrefix(String[] strs) {
            int minLength = strs[0].length();
            int minIndex = 0;
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i + 1].length() < minLength) {
                    minLength = strs[i + 1].length();
                    minIndex = i + 1;
                }
            }
            String minStr = strs[minIndex];
            Set<String> allSubMinStr = new HashSet<>();
            for (int i = 0; i < minStr.length(); i++) {
                for (int j = i; j < minStr.length(); j++) {
                    allSubMinStr.add(minStr.substring(i, j + 1));
                }
            }
            LinkedHashSet<String> sortedSubMinStr = allSubMinStr.stream().sorted((a, b) -> {
                if (a.length() < b.length()) {
                    return -1;
                } else if (a.length() > b.length()) {
                    return 1;
                }
                return 0;
            }).collect(Collectors.toCollection(LinkedHashSet::new));
            String[] strList = new String[sortedSubMinStr.size()];
            int index = sortedSubMinStr.size() - 1;
            for (String str : sortedSubMinStr) {
                strList[index] = str;
                index--;
            }
            int haveCount = 0;
            for (String subStr : strList) {
                haveCount = 0;
                for (String str : strs) {
                    if (str.indexOf(subStr) != -1) {
                        haveCount++;
                    }
                }
                if (haveCount == strs.length) {
                    return subStr;
                }
            }
            return "";

        }
    }
    
}
