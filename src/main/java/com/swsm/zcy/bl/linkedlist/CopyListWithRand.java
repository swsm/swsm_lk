package com.swsm.zcy.bl.linkedlist;

import java.util.HashMap;

/**
 * @author liujie
 * @date 2023-06-15
 */
public class CopyListWithRand {

    static class Node {
        // 节点值
        int value;
        // 下一节点
        Node next;
        // 随机节点
        Node rand;
        Node(int val) {
            value = val;
        }

    }

    /**
     * 通过hashmap完成 复制链表并返回头节点
     * 1. 从头节点开始，不停找下一节点，并把每一节点作为key放到map中存储，用节点值构建新的节点作为map的value
     * 2. 再从头节点开始，通过map找到复制的新节点并将新节点的next指向 从map找到当前节点的next对应在map中的复制的新节点
     * 3. 通过map找到复制的新节点并将新节点的rand指向 从map找到当前节点的rand对应在map中的复制的新节点
     * 4. 当前节点变成当前节点的下一节点，继续循环2
     * @param head
     * @return
     */
    public static Node copyListWithRand(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 在原链表中操作，不申请额外空间进行链表的复制
     * 1. 循环遍历链表，在每个节点后插入新的复制节点
     * 2. 再次循环遍历链表，通过当前节点的next找到复制的链表，next.next找到当前节点的原下一节点，rand找到当前节点的rand节点，这样就在一个链表中完成复制节点的指向复制了
     * 3. 复制链表从原链表中拆除，并返回复制链表的head
     * @param head
     * @return
     */
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // 1 -> 2
        // 1 -> 1' -> 2
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // 处理rand节点指向
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : next;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.rand = node3;
        node2.rand = node1;
        node3.rand = node1;
        node4.rand = node2;
        Node cur = node1;
        while (cur != null) {
            System.out.print("" + cur.value 
                    + " next:" + (cur.next == null ? null : cur.next.value)
                    + " rand:" + (cur.rand == null ? null : cur.rand.value) + ";");
            cur = cur.next;
        }
        System.out.println();
        Node newNode1 = copyListWithRand(node1);
        cur = newNode1;
        while (cur != null) {
            System.out.print("" + cur.value
                    + " next:" + (cur.next == null ? null : cur.next.value)
                    + " rand:" + (cur.rand == null ? null : cur.rand.value) + ";");
            cur = cur.next;
        }
        System.out.println();
        
        newNode1 = copyListWithRand2(node1);
        cur = newNode1;
        while (cur != null) {
            System.out.print("" + cur.value
                    + " next:" + (cur.next == null ? null : cur.next.value)
                    + " rand:" + (cur.rand == null ? null : cur.rand.value) + ";");
            cur = cur.next;
        }
        System.out.println();
    }
    
    
}
