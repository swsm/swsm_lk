package com.swsm.zcy.bl.greedy;

import java.util.HashSet;

/**
 * @author liujie
 * @date 2023-07-01
 */
public class Light {
    
    public static int minLight1(String road) {
        if (road == null || road.length() == 0) {
            return 0;
        }
        return process(road.toCharArray(), 0, new HashSet<>());
    }

    /**
     * str[index...]的位置，自由选择放灯还是不放灯
     * str[0..index-1]位置，已经做完决定了，lights：哪些位置放了灯
     * 要求选出能照亮所有.的方案，并且在这些有效的方案中，返回最少需要几个灯
     */
    public static int process(char[] str, int index, HashSet<Integer> lights) {
        if (index == str.length) { // 结束的时候
            // 
            for (int i = 0; i < str.length; i++) {
                if (str[i] != 'X') {
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else {
            // str还没结束
            // i位置无论是x .，没有放灯返回后续的选择
            int no = process(str, index + 1, lights);
            // i位置无论是x .，放灯返回后续的选择，先默认是最大值，判断是.才可以放灯然后继续走递归
            int yes = Integer.MAX_VALUE;
            if (str[index] == '.') {
                lights.add(index);
                yes = process(str, index + 1, lights);
                // 走完之后需要恢复现场，因为整个流程都是使用一个lights来处理的
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

    /**
     * 贪心处理
     * 逻辑：
     * 1. 如果 当前位置是 X 则index++
     * 2. 否则 先放灯
     * 3. 再判断 index + 1== length,如果等于则break；处理完成
     * 4. 否则判断 str[index + 1] 是否等于'X', 如果等于则 index = index+2 （跳过它向下继续判断）
     * 5. 否则 str[index + 1]就是.这个时候 index = index + 3,（跳过2个，因为连续两个地方有灯则放第二个位置）
     * 6. 循环1
     */
    public static int minLight2(String road) {
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == str.length) {
                    break;
                } else {
                    if (str[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        return light;
    }
    
    
}
