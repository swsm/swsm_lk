package com.swsm.lik.basic.str.q3;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 *  
 *
 * 提示:
 *
 * 1 <= s.length <= 105
 * s 只包含小写字母
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn5z8r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author liujie
 * @date 2022/11/29
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "aabb";
        Solution solution = new Solution();
        int i = solution.firstUniqChar(s);
        System.out.println("res=" + i);
    }

    static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    map.put(chars[i], -1);
                } else {
                    map.put(chars[i], i);
                }
            }
            for (Integer value : map.values()) {
                if (value != -1) {
                    return value;
                }
            }
            return -1;
        }
    }
    
}
