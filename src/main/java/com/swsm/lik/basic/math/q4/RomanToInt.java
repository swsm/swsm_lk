package com.swsm.lik.basic.math.q4;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * 
 * 输入: s = "III"
 * 输出: 3
 * 
 * 输入: s = "IV"
 * 输出: 4
 * 
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * @author liujie
 * @date 2022/12/14
 */
public class RomanToInt {
    
    public static final char I = 'I';
    public static final char V = 'V';
    public static final char X = 'X';
    public static final char L = 'L';
    public static final char C = 'C';
    public static final char D = 'D';
    public static final char M = 'M';
    
    public static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put(I, 1);
        map.put(V, 5);
        map.put(X, 10);
        map.put(L, 50);
        map.put(C, 100);
        map.put(D, 500);
        map.put(M, 1000);
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        Solution solution = new Solution();
        int res = solution.romanToInt(s);
        System.out.println("res=" + res);
    }
    
    
    static class Solution {
        public int romanToInt(String s) {
            int sum = 0;
            //前一个数字表示的值
            int preNum = getValue(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                int num = getValue(s.charAt(i));
                //如果前一个数字比现在数字小，说明
                //前一个字符和现在字符组合成一个有效数字，
                if (preNum < num) {
                    sum -= preNum;
                } else {
                    //如果前一个数字不比现在数字小，说明
                    //每个字符都是一个有效的数字
                    sum += preNum;
                }
                preNum = num;
            }
            sum += preNum;
            return sum;
        }

        private int getValue(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }
    
}
