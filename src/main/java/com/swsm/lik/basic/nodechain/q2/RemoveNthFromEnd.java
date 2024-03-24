package com.swsm.lik.basic.nodechain.q2;

/**
 * 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * 
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 
 * @author liujie
 * @date 2022/12/4
 */
public class RemoveNthFromEnd {
    
    

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        Solution solution = new Solution();
        ListNode node = solution.removeNthFromEnd(node1, 4);
        ListNode next = node;
        while (next != null) {
            System.out.print(next.val + "  ");
            next = next.next;
        }
    }

    /**
     * 答案的递归解决思路，代码简洁，思路清晰
     */
    static class Solution {
        public ListNode  removeNthFromEnd(ListNode head, int n) {
            int pos = length(head, n);
            // 说明删除的是头节点
            if (pos == n)
                return head.next;
            return head;
        }

        // 获取节点所在位置，逆序
        public int length(ListNode node, int n) {
            if (node == null)
                return 0;
            int pos = length(node.next, n) + 1;
            //获取要删除链表的前一个结点，就可以完成链表的删除
            if (pos == n + 1)
                node.next = node.next.next;
            return pos;
        }
    }

    /**
     * 自己写的递归，递归中
     */
    static class SolutionMineRecursion {
        private int index = 0;
        private int length = 0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (n == 1 && head.next == null) {
                return null;
            }
            recursion(head, n);
            return head;
        }
        
        public void recursion(ListNode head, int n) {
            int currentIndex = index;
            if (head == null) {
                length = index;
                return;
            }
            if (n == 1) {
                // 要删除的是最后一个节点
                if (head.next.next == null) {
                    head.next = null;
                    return;
                }
            }
            index++;
            recursion(head.next, n);
            if (currentIndex == length - n) {
                // 当前节点为要删除的节点
                if (head.next != null) {
                    head.val = head.next.val;
                    head.next = head.next.next;
                } 
            }
        }
        
    }
    
    static class SolutionMine {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = head;
            int length = 0;
            while(node != null) {
                length++;
                if (n == 1) {
                    if (node.next == null) {
                        return null;
                    } else if ( node.next.next == null) {
                        // 删除的是最后一个节点
                        node.next = null;
                        return head;
                    }
                }
                node = node.next;
            }
            int nodeIndex = length - n;
            int index = 0;
            node = head;
            while (true) {
                if (index == nodeIndex) {
                    if (node == head) {
                        head = node.next;
                        return head;
                    } else {
                        node.val = node.next.val;
                        node.next = node.next.next;
                        return head;
                    }
                }
                node = node.next;
                index++;
            }
        }
    }
    
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
}
