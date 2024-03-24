package com.swsm.zcy.bl.tree;

/**
 * @author liujie
 * @date 2023-06-25
 */
public class PrintTree {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 把二叉树横向打印
     * 逻辑：从头节点开始，注意节点方向，使用固定长度占用，先打印右节点，再打印左节点，依次向下
     * @param head
     */
    public static void printTree(Node head) {
        System.out.println("Binary Tree: ");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }
    
    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }
    
    public static String getSpace(int num) {
        String space = " ";
        StringBuilder  strb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            strb.append(space);
        }
        return strb.toString();
    }
    
}
