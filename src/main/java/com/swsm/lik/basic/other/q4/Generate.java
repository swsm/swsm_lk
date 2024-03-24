package com.swsm.lik.basic.other.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 
 * @author liujie
 * @date 2023-01-10
 */
public class Generate {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numRows = 4;
        List<List<Integer>> res = solution.generate(numRows);
        for (List<Integer> re : res) {
            System.out.print(Arrays.toString(re.toArray()));
        }
    }
    
    
    static class Solution {

        public List<List<Integer>> generate(int n) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> li = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        li.add(1);
                    } else {
                        //第i层的第j个元素 = i-1层的第j个元素 + i-1层的第j-1元素
                        li.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                    }
                }
                list.add(li);
            }
            return list;
        }
        
        public List<List<Integer>> generateMe(int numRows) {
            List<List<Integer>> finalRes = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                List<Integer> res = new ArrayList<>();
                if (i == 1) {
                    res.add(1);
                } else {
                    List<Integer> lastRes = finalRes.get(i - 1 - 1);
                    for (int j = 0; j < i; j++) {
                        if (j == 0 || j == lastRes.size()) {
                            res.add(lastRes.get(j == 0 ? j : j - 1));
                        } else {
                            res.add(lastRes.get(j - 1) + lastRes.get(j));
                        }
                    }
                }
                finalRes.add(res);
            }
            return finalRes;
        }
    }
    
}
