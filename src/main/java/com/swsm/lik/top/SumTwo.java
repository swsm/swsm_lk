package com.swsm.lik.top;

/**
 * @author liujie
 * @date 2023-07-13
 */
public class SumTwo {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;
        int val = 0;
        boolean carryFlag = false;
        while (l1 != null || l2 != null) {
            val = 0;
            if (l1 != null) {
                val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val = val + l2.val;
                l2 = l2.next;
            }
            if (carryFlag) {
                val = val + 1;
            }
            if (val > 9) {
                carryFlag = true;
                val = val - 10;
            } else {
                carryFlag = false;
            }
            if (head == null) {
                head = new ListNode(val);
                cur = head;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carryFlag) {
            cur.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {
        SumTwo sumTwo = new SumTwo();
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
//        ListNode b4 = new ListNode(9);
        b1.next = b2;
        b2.next = b3;
//        b3.next = b4;

        ListNode head = sumTwo.addTwoNumbers(a1, b1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }




    
    
    
}
