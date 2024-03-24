package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-07-05
 */
public class Hanoi {
    
    public static void hanoi1(int n) {
        leftToRight(n);
    }
    
    // 请把1-n层圆盘，从左到右
    public static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("move 1 from left to right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("move " + n + " from left to right");
        midToRight(n - 1);
    }

    // 把1-n层圆盘，从左到中
    public static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("move " + n + " from left to mid");
        rightToMid(n - 1);
    }
    
    public static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from right to mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("move " + n + " from right to mid");
        leftToMid(n - 1);
    }

    public static void midToRight(int n) {
        if (n == 1) {
            System.out.println("move 1 from mid to right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("move " + n + " from mid to right");
        leftToRight(n - 1);
    }

    public static void midToLeft(int n) {
        if (n == 1) {
            System.out.println("move 1 from mid to left");
            return;
        }
        midToRight(n - 1);
        System.out.println("move " + n + " from mid to left");
        rightToLeft(n - 1);
    }

    public static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("move 1 from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("move " + n + " from right to mid");
        midToLeft(n - 1);
    }
    
    public static void hanoi2(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }
    
    public static void func(int N, String from, String to, String other) {
        if (N == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            func(N - 1, from, other, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            func(N - 1, other, to, from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi1(3);
        System.out.println("=============");
        hanoi2(n);
    }
    
}
