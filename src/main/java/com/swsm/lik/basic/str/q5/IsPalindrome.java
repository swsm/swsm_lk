package com.swsm.lik.basic.str.q5;

/**
 * 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * @author liujie
 * @date 2022/11/30
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "0P";
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(s);
        System.out.println("res=" + palindrome);
    }
    
    
    static class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            int leftIndex = 0;
            int rightIndex = length - 1;
            for (int i = 0; i < length; i++) {
                if (!((chars[leftIndex] <= 'Z' && chars[leftIndex] >= 'A') 
                        || (chars[leftIndex] <= '9' && chars[leftIndex] >= '0') 
                        || (chars[leftIndex] <= 'z' && chars[leftIndex] >= 'a'))){
                    leftIndex++;
                    continue;
                }
                if (!((chars[rightIndex] <= 'Z' &&  chars[rightIndex] >= 'A') 
                        || (chars[rightIndex] <= '9' && chars[rightIndex] >= '0')
                        || (chars[rightIndex] <= 'z' && chars[rightIndex] >= 'a'))){
                    rightIndex--;
                    continue;
                }
                if (Character.toLowerCase(chars[leftIndex]) != Character.toLowerCase(chars[rightIndex])) {
                    return false;
                }
                if (leftIndex == rightIndex) {
                    return true;
                }
                leftIndex++;
                rightIndex--;
            }
            return true;
        }
    }
}
