package com.swsm.zcy.bl.linkedlist;

/**
 * @author liujie
 * @date 2023-06-16
 */
public class LoopNode {
    
    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 两个链表是否有环，无环返回null有环返回相交的第一个节点
     * 逻辑：
     * 1. 慢指针n1快指针n2向前走
     * 2. 当两个指针有一个走到null则不相交，否则必有一个相交的点
     * 3. 当两个指针相交后，快指针从头开始一步步走慢指针从当前节点一步步向下走，再次相遇的节点就是相交的第一个节点
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                // 无环
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        // 有环
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
    
    
}
