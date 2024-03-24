package com.swsm.lik.basic.math.q1;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 *
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 *
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * 
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * @author liujie
 * @date 2022/12/14
 */
public class FizzBuzz {

    public static void main(String[] args) {
        int n = 15;
        Solution solution = new Solution();
        List<String> res = solution.fizzBuzz(n);
        System.out.println("res=" + res);
    }
    
    
    static class Solution {
        
        private static final String FIZZ = "Fizz";
        private static final String BUZZ = "Buzz";
        
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    res.add(FIZZ + BUZZ);
                } else if (i % 3 == 0) {
                    res.add(FIZZ);
                } else if (i % 5 == 0) {
                    res.add(BUZZ);
                } else {
                    res.add(i + "");
                }
            }
            return res;
        }
    }
    
}
