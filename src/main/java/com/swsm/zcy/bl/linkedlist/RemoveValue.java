package com.swsm.zcy.bl.linkedlist;

/**
 * @author liujie
 * @date 2023-06-10
 */
public class RemoveValue {

    /**
     * 删除指定值的链表节点
     * 逻辑：
     * 1. 判断头节点是否为指定值，如果是则头节点等于其next
     * 2. 一直循环1，直到当前值不是指定值
     * 3. 准备两个指针，cur，pre，首先两个指针都指向当前节点
     * 4. 如果cur指针不等于null，则判断cur的值是否等于指定值，等于则cur的next赋给pre的next，完成cur节点的删除，不等于则cur赋值给pre，cur为cur的next，
     * 5. 重复4
     * 6. 最后返回head节点
     */
    public static Node remove(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // head来到第一个不是num的位置
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(1);
        Node node6 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node head = remove(node1, 1);
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }

    }
    
}
