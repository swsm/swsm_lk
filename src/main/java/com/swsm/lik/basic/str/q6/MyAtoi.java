package com.swsm.lik.basic.str.q6;

/**
 * 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 
 *
 * @author liujie
 * @date 2022/12/1
 */
public class MyAtoi {

    public static void main(String[] args) {
        String ss = "3.14159";
        Solution solution = new Solution();
        int res = solution.myAtoi(ss);
        System.out.println("res=" + res);
    }
    
    static class Solution {
        public int myAtoi(String s) {
            s = s.trim();//去掉前后的空格
            //如果为空，直接返回0
            if (s.length() == 0)
                return 0;
            int index = 0;//遍历字符串中字符的位置
            int res = 0;//最终结果
            int sign = 1;//符号，1是正数，-1是负数，默认为正数
            int length = s.length();
            //判断符号
            if (s.charAt(index) == '-' || s.charAt(index) == '+')
                sign = s.charAt(index++) == '+' ? 1 : -1;
            for (; index < length; ++index) {
                //取出字符串中字符，然后转化为数字
                int digit = s.charAt(index) - '0';
                //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
                //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
                if (digit < 0 || digit > 9)
                    break;
                //越界处理
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                else
                    res = res * 10 + digit;
            }
            return sign * res;
        }
    }

    static class SolutionMine {
        public int myAtoi(String s) {
            Double res = 0D;
            Boolean isFu = null;
            char[] chars = s.toCharArray();
            String zsStr = "";
            for (int i = 0; i < chars.length; i++) {
                if (!(chars[i] >= '0' && chars[i] <= '9' || (zsStr.length() == 0 && chars[i] == ' ') || chars[i] == '-' || chars[i] == '+' )) {
                    break;
                }
                if (chars[i] == ' ') {
                    continue;
                }
                if (isFu != null && (chars[i] == '+' || chars[i] == '-')) {
                    return 0;
                }
                if (chars[i] == '-') {
                    if (zsStr.length() != 0) {
                        break;
                    }
                    isFu = true;
                    continue;
                }
                if (chars[i] == '+') {
                    if (zsStr.length() != 0) {
                        break;
                    }
                    isFu = false;
                    continue;
                }
                zsStr += chars[i];
            }
            char[] zsChar = zsStr.toCharArray();
            for (int i = 0; i < zsChar.length; i++) {
                res += (zsChar[i] - 48) * Math.pow(10, zsChar.length - i - 1);
            }
            if (isFu == null) {
                isFu = false;
            }
            if (isFu && -1 * res <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!isFu && res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return isFu ? -1 * res.intValue() : res.intValue();
        }
    }
    
    
}
