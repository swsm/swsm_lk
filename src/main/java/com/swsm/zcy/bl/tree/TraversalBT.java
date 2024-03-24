package com.swsm.zcy.bl.tree;

import java.util.Stack;

/**
 * @author liujie
 * @date 2023-06-17
 */
public class TraversalBT {
    
    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 递归序
     * 每个节点都到达3次，先中后序只是到达的次数不同的时候打印而已
     */
    public static void f(Node head) {
        if (head == null) {
            return;
        }
        f(head.left);
        f(head.right);
    }

    /**
     * 先序打印所有节点
     */
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }
    
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }
    
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }
    
    
    public static void pre2(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 整条左边界依次入栈
     * 左边无的时候，弹出节点就打印，head来到右树继续重复执行
     * @param head
     */
    public static void in2(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if(head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }


    public static void pos2(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }
    
    public static void pos3(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.println(stack.pop().value + " ");
                    head = c;
                }
            }   
        }
        System.out.println();
    }
    
}
