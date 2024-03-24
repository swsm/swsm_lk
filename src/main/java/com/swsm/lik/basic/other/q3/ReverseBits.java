package com.swsm.lik.basic.other.q3;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *  
 *
 * 示例 1：
 *
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *
 * @author liujie
 * @date 2023-01-10
 */
public class ReverseBits {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = Integer.parseUnsignedInt("10010110111001001101001111110101", 2);
        int res = solution.reverseBits(n);
        System.out.println("res=" + res);
    }
    
    
    
    static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            String binaryString = Integer.toBinaryString(n);
            int length = binaryString.length();
            for (int i = 0; i < 32 - length; i++) {
                binaryString = "0" + binaryString;
            }
            length = binaryString.length();
            char[] chars = binaryString.toCharArray();
            char c = ' ';
            for (int i = 0; i < length / 2; i++) {
                c = chars[i];
                chars[i] = chars[length - i - 1];
                chars[length - i - 1] = c;
            }
            return Integer.parseUnsignedInt(new String(chars), 2);
        }
    }
    
    
    
}
