package com.swsm.zcy.bl.eor;

/**
 * 计算一个数字的二进制中1的个数
 * 逻辑：
 * 1. 当n不为0时，通过 n & (~n + 1) 获得n的最右的1 为 x
 * 2. count++
 * 3. n和x异或一下，n最右侧的1就变成0了，新的值赋给n
 * 4. 然后继续执行1
 * 
 * @author liujie
 * @date 2023-06-10
 */
public class FindBitOneCount {

    public static void main(String[] args) {
        int n = 1;
        int res = countOne(n);
        System.out.println(res);
    }
    
    public static int countOne(int n) {
        int count = 0;
        while (n != 0) {
            int rightOne = n & (~n + 1);
            count++;
            n = n ^ rightOne;
        }
        return count;
    }
    
}
