package com.swsm.zcy.bl.recursion;

import java.util.HashMap;

/**
 * @author liujie
 * @date 2023-07-12
 */
public class StickersToSpellWord {
    
    public static int minStickers1(String[] stickers, String target) {
        int n = stickers.length;
        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c - 'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return process1(dp, map, target);
    }
    
    public static int process1(HashMap<String, Integer> dp, int[][] map, String t) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }
        int ans = Integer.MAX_VALUE;
        int n = map.length;
        int[] temp = new int[26];
        char[] target = t.toCharArray();
        for (char c : target) {
            temp[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            // 判断当前贴纸 是否包含目标贴纸中的第0位置的字符，不包含则continue
            if (map[i][target[0] - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            // i 贴纸 j 枚举a~z字符   sb里面放的就是减去 i号贴纸后 剩余的字符
            for (int j = 0; j < 26; j++) {
                if (temp[j] > 0) {
                    for (int k = 0; k < Math.max(0, temp[j] - map[i][j]); k++) {
                        sb.append((char)('a' + j));
                    }
                }
            }
            String s = sb.toString();
            int tmp = process1(dp, map, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        // ans还是最大则 表示这种方案没法解决
        dp.put(t, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(t);
    }
    
    
}
