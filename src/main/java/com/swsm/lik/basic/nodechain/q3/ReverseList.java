package com.swsm.lik.basic.nodechain.q3;

/**
 * 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @author liujie
 * @date 2022/12/4
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        ListNode node = solution.reverseList(node1);
        ListNode next = node;
        while (next != null) {
            System.out.print(next.val + "  ");
            next = next.next;
        }
    }

    /**
     * 循环处理，每个节点进行反向
     */
    static class SolutionCycle {
        public ListNode reverseList(ListNode head) {
            ListNode last = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = last;
                last = head;
                head = temp;
            }
            return last;
        }
    }
    
    
    /**
     * 
     */
    static class SolutionFor {
        public ListNode reverseList(ListNode head) {
            //新链表
            ListNode newHead = null;
            while (head != null) {
                //先保存访问的节点的下一个节点，保存起来
                //留着下一步访问的
                ListNode temp = head.next;
                //每次访问的原链表节点都会成为新链表的头结点，
                //其实就是把新链表挂到访问的原链表节点的
                //后面就行了
                head.next = newHead;
                //更新新链表
                newHead = head;
                //重新赋值，继续访问
                head = temp;
            }
            //返回新链表
            return newHead;
        }

    }

    /**
     * 递归调用
     * 1. 终止条件
     * 2. 逻辑处理(可为空)
     * 3. 递归调用
     * 4. 逻辑处理(可为空)
     */
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode reverse = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return reverse;
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
