package com.swsm.lik.basic.nodechain.q6;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 方法：
 * 1. 快慢指针，相遇则表示有环
 * 2. 节点存Set集合，比较存在则表示有环
 * 3. 删除节点，最后发现head = head.next 则表示有环
 * 4. 反转链表，反转后的链表head和原head是同一个，则表示有环
 * 
 * @author liujie
 * @date 2022/12/5
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Solution solution = new Solution();
        boolean res = solution.hasCycle(node1);
        System.out.println("res=" + res);
    }
    
    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = null;
            while (fast.next != null) {
                if (fast.next.next == null) {
                    return false;
                }
                if (fast == slow) {
                    return true;
                }
                fast = fast.next.next;
                slow = slow == null ? head : slow.next;
            }
            return false;
        }
    }
    
    
    static class SolutionMine {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> nodes = new HashSet<>();
            int index = 0;
            while(head != null) {
                if (nodes.contains(head)) {
                    return true;
                } 
                nodes.add(head);
                head = head.next;
            }
            return false;
        }
    }
    
    static class ListNode {
        private int val;
        private ListNode next;
        public ListNode(){};
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
}
