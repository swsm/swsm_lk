package com.swsm.zcy.bl.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liujie
 * @date 2023-06-29
 */
public class BestArrange {
    
    public static class Program {
        public int start;
        public int end;
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static int bestArrange1(Program[] programs) {
        if (programs == null || programs.length == 0) {
            return 0;
        }
        return process(programs, 0, 0);
    }

    /**
     * 目前来到timeLine的时间点，已经安排了done多的会议，剩下的会议可以自有安排
     * 
     * @param programs 还剩什么会议都放在programs里
     * @param done 之前已经安排了多少会议，数量
     * @param timeLine 目前来到的时间点是什么
     * @return 能安排的最多会议数量
     */
    public static int process(Program[] programs, int done, int timeLine) {
        if (programs.length == 0) {
            return done;
        }
        // 还有会议可以选
        int max = done;
        // 当前安排的会议是什么会， 每一个都枚举
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeLine) {
                Program[] next = copyButExcept(programs, i);
                max = Math.max(max, process(next, done + 1, programs[i].end));
            }
        }
        return max;
    }
    
    public static Program[] copyButExcept(Program[] programs, int i) {
        Program[] ans = new Program[programs.length - 1];
        int index = 0;
        for (int k = 0; k < programs.length; k++) {
            if (k != i) {
                ans[index++] = programs[k];
            }
        }
        return ans;
    }
    
    public static int bestArrange2(Program[] programs) {
        Arrays.sort(programs, new ProgramComparator());
        int timeLine = 0;
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timeLine <= programs[i].start) {
                result++;
                timeLine = programs[i].end;
            }
        }
        return result;
    }
    
    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end -o2.end;
        }
    }
    
    
}
