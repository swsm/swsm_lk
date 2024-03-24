package com.swsm.lik.basic.str.q4;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * @author liujie
 * @date 2022/11/30
 */
public class IsAnagram {

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";
        Solution solution = new Solution();
        boolean anagram = solution.isAnagram(str1, str2);
        System.out.println("res=" + anagram);
    }
    
    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            int[] letterCount = new int[26];
            //统计字符串s中的每个字符的数量
            for (int i = 0; i < s.length(); i++)
                letterCount[s.charAt(i) - 'a']++;
            //减去字符串t中的每个字符的数量
            for (int i = 0; i < t.length(); i++) {
                //如果当前字符等于0，直接返回false，
                if (letterCount[t.charAt(i) - 'a'] == 0)
                    return false;
                letterCount[t.charAt(i) - 'a']--;
            }
            return true;
        }
    }

    static class SolutionMine {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();
            for (char c : chars1) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            for (char c : chars2) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                } else {
                    return false;
                }
            }
            for (Integer value : map.values()) {
                if (value != 0) {
                    return false;
                }
            }
            return true;

        }
    }
    
}
