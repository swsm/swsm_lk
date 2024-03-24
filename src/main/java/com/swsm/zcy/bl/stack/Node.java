package com.swsm.zcy.bl.stack;

/**
 * @author liujie
 * @date 2023-06-10
 */
public class Node<T> {
    public T value;
    public Node<T> last;
    public Node<T> next;
    
    public Node(T data) {
        this.value = data;
    }
    
    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;
        public void addFromHead(T value) {
            Node<T> cur = new Node<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            
        }
    }
    
}
