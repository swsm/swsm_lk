package com.swsm.lik.basic.nodechain.q4;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnbp2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author liujie
 * @date 2022/12/4
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node33 = new ListNode(4);
        node11.next = node22;
        node22.next = node33;

        Solution solution = new Solution();
        ListNode node = solution.mergeTwoLists(node1, node11);
        ListNode next = node;
        while (next != null) {
            System.out.print(next.val + "  ");
            next = next.next;
        }
    }
    
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            }
            
            ListNode head = new ListNode();
            ListNode currentNode = head;
            while (true) {
                if (list1.val <= list2.val) {
                    currentNode.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    currentNode.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                currentNode = currentNode.next;

                if (list1 == null) {
                    while (list2 != null) {
                        currentNode.next = new ListNode(list2.val);
                        currentNode = currentNode.next;
                        list2 = list2.next;
                    }
                    return head.next;
                } else if (list2 == null) {
                    while (list1 != null) {
                        currentNode.next = new ListNode(list1.val);
                        currentNode = currentNode.next;
                        list1 = list1.next;
                    }
                    return head.next;
                }
                
                if (list1 == null && list2 == null) {
                    return head.next;
                }
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
