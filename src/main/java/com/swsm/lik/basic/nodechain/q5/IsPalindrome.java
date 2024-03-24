package com.swsm.lik.basic.nodechain.q5;

/**
 * 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 
 * 输入：head = [1,2]
 * 输出：false
 * 
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author liujie
 * @date 2022/12/5
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        
        Solution solution = new Solution();
        boolean res = solution.isPalindrome(node1);
        System.out.println("res=" + res);
        
        
    }

    /**
     * 快慢指针方法，快的2步一走，慢的一步一走，当快的走到最后的时候，正好慢的走到中间节点，
     * 然后再从中间节点反转后续节点，
     * 反转完成后，快指针指向头节点，开始一步步走，两个走到一起都相等则表明是回文链表，否则不是回文链表
     */
    static class Solution {
        public boolean isPalindrome(ListNode node) {
            return true;
        }
    }

    /**
     * 递归倒序解决 
     */
    static class SolutionRecursion {
        
        ListNode temp;
        
        public boolean isPalindrome(ListNode head) {
            temp = head;
            return orderAndReverse(head);
        }
        
        private boolean orderAndReverse(ListNode head) {
            if (head == null) {
                return true;
            }
            boolean res = orderAndReverse(head.next) && temp.val == head.val;
            temp = temp.next;
            return res;
        }
    }
    
    private static void reverseFor(ListNode head) {
        if (head == null) {
            return;
        }
        reverseFor(head.next);
        System.out.print(head.val + "  ");
    }
    
    static class SolutionMine {
        public boolean isPalindrome(ListNode head) {
            StringBuilder sb1 = new StringBuilder();
            while (head != null) {
                sb1.append(head.val);
                head = head.next;
            }
            for (int i = 0; i < sb1.length() / 2; i++) {
                if (sb1.charAt(i) != sb1.charAt(sb1.length() - i - 1)) {
                    return false;
                }
            }
            return true;
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
