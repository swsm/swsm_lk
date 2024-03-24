package com.swsm.zcy.bl.recursion;

import java.util.Stack;

/**
 * @author liujie
 * @date 2023-07-06
 */
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverseStack(stack);

        System.out.println("==========");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(f(stack));
        }
    }
    
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer value = stack.pop();
        if (!stack.isEmpty()) {
            reverseStack(stack);
        }
        System.out.println(value);
    }
    
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }
    
    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
    
    
}
