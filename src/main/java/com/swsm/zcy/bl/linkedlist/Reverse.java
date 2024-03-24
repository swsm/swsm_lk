package com.swsm.zcy.bl.linkedlist;

/**
 * @author liujie
 * @date 2023-06-10
 */
public class Reverse {

    public static void main(String[] args) {
        
    }

    /**
     * 逆转单链表(必须得用两个指针)
     * 逻辑：
     * 1. 准备两个节点 pre，next
     * 2. 当head不为null
     * 3. next指向head的next，head的next指向pre，pre指向head，head指向next，完成头两个节点的逆转，head指向下一个节点
     * 4. 循环2直到head为null
     * 5. 返回pre
     */
    public Node reverseNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 逆向双链表(必须得用两个指针)
     * 逻辑：
     * 1. 准备两个指针pre next
     * 2. 交换当前节点和当前节点的下一节点指向，pre指向当前节点，next指向下一节点，head也指向下一节点
     * 3. 继续循环2，直到head为null
     * 4. 返回pre节点
     * @param head
     * @return
     */
    public DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    
}
