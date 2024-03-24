package com.swsm.lik.basic.str.q1;

import java.util.Arrays;

/**
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * @author liujie
 * @date 2022/11/29
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] str = {'h','e','l','o'};
        Solution solution = new Solution();
        solution.reverseString(str);
        System.out.println("res=" + Arrays.toString(str));
    }
    
    static class Solution {
        public void reverseString(char[] s) {
            char temp;
            for (int i = 0; i < s.length / 2; i++) {
                temp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = temp;
            }
        }
    }
    
}
