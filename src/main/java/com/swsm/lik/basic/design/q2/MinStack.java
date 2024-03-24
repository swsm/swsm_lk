package com.swsm.lik.basic.design.q2;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * 
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 可以使用链表来解决
 * 
 * @author liujie
 * @date 2022/12/14
 */
public class MinStack {

    public static void main(String[] args) {
        
    }
    
    List<Integer> list;
    int validSize = -1;
        
    public MinStack() {
        list = new ArrayList<>();
        fill(0, 16);
    }
    
    private void fill(int start, int end) {
        for(int i = start; i < end; i++) {
            list.add(null);
        }
    }

    public void push(Integer val) {
        validSize++;
        if (list.size() <= validSize) {
            fill(list.size(), 2 * list.size());
        }
        list.set(validSize, val);
    }

    public void pop() {
        if (validSize == -1) {
            return;
        }
        validSize--;
    }

    public Integer top() {
        if (validSize == -1) {
            return null;
        }
        return list.get(validSize);
    }

    public Integer getMin() {
        if (validSize == -1) {
            return null;
        }
        int min = list.get(0);
        for (int i = 1; i <= validSize; i++) {
            min = Math.min(min, list.get(i));
        }
        return min;
    }
    
}
