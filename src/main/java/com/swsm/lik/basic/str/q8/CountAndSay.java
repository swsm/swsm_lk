package com.swsm.lik.basic.str.q8;

/**
 * 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1 
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 * @author liujie
 * @date 2022/12/3
 */
public class CountAndSay {

    public static void main(String[] args) {
        int aa = 5;
        Solution solution = new Solution();
        String res = solution.countAndSay(aa);
        System.out.println("res=" + res);
    }
    
    static class Solution {
        public String countAndSay(int n) {
            String res = "1";
            char currentValue = ' ';
            char lastValue = ' ';
            int length = res.length();
            int lastValueCount = 0;
            StringBuilder tempRes = new StringBuilder();
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < length; j++) {
                    currentValue = res.charAt(length - j - 1);
                    if (currentValue == lastValue) {
                        lastValueCount++;
                    } else {
                        if (lastValue != ' ') {
                            tempRes.insert(0, lastValueCount + "" + lastValue);
                        }
                        lastValue = currentValue;
                        lastValueCount = 1;
                    }
                }
                res = lastValueCount + "" + lastValue + tempRes;
                lastValue = ' ';
                lastValueCount = 0;
                length = res.length();
                tempRes = new StringBuilder();
            }
            return res;
        }
    }

    static class SolutionMine {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            int val = 1;
            String res = say("1");
            val++;
            while (val < n) {
                res = say(res);
                val++;
            }
            return res;
        }

        private String say(String ss) {
            int n = ss.length();
            char currentValue = ' ';
            String res = "";
            char lastValue = ' ';
            int lastValueCount = 0;
            for (int i = 0; i < ss.length(); i++) {
                currentValue = ss.charAt(n - i - 1);
                if (currentValue == lastValue) {
                    lastValueCount++;
                } else {
                    if (lastValue != ' ') {
                        res = lastValueCount + "" + lastValue + res;
                    }
                    lastValue = currentValue;
                    lastValueCount = 1;
                }
            }
            res = lastValueCount + "" + lastValue + res;
            return res;
        }
    }

}
