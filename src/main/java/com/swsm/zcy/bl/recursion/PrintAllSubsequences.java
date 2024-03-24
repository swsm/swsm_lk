package com.swsm.zcy.bl.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author liujie
 * @date 2023-07-06
 */
public class PrintAllSubsequences {
    
    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }

    /**
     * str固定，不变
     * index此时来到的位置，要 or 不要
     * 如果 index来到了str中的终止位置，把沿途路径形成的答案，放入到ans中
     * 之前做出的选择，就是path
     */
    public static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        // 没要当前路径位置字符就往下传
        process1(str, index + 1, ans, no);
        
        String yes = path + str[index];
        // 要了当前路径位置字符往下传
        process1(str, index + 1, ans, yes);
    }
    
    
    public static List<String> subsNoRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<>();
        process2(str, 0, set, path);
        List<String> ans =  new ArrayList<>();
        for (String cur : set) {
            ans.add(cur);
        }
        return ans;
    }
    
    public static void process2(char[] str, int index, HashSet<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }
        String no = path;
        process2(str, index + 1, set, no);
        String yes = path + str[index];
        process2(str, index + 1, set, yes);
    }
    
    
}
