package com.swsm.zcy.bl.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liujie
 * @date 2023-06-25
 */
public class SerializeAndReconstructTree {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 前序 序列化二叉树
     * 逻辑：
     * 1. 定义queue
     * 2. 进入递归前序遍历函数
     * 3. 如果当前节点为null则 null加入queue
     * 4. 否则 queue加入 节点的值， 
     * 5. 递归调用左孩子
     * 6. 递归调用右孩子
     * 7.递归完成返回 queue队列
     */
    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedBlockingQueue<>();
        pres(head, ans);
        return ans;
    }
    
    public static void pres(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    /**
     * 反序列化前序的二叉树
     * 逻辑：
     * 1. 如果前序列表为空则返回null
     * 2. 开始递归处理列表
     * 3. 从队列中弹出数据value
     * 4. baseCase 如果value=null则返回null
     * 5. 用value构造新节点node
     * 6. 递归构造左孩子节点，并将node.left指向左孩子
     * 7. 递归构造右孩子节点，并将node.right指向右孩子
     * 8. 返回当前节点
     * @param preList
     * @return
     */
    public static Node buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preb(preList);
    }
    
    public static Node preb(Queue<String> preList) {
        String value = preList.poll();
        if (value == null) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = preb(preList);
        head.right = preb(preList);
        return head;
    }
    
    
    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedBlockingQueue<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            Queue<Node> queue = new LinkedBlockingQueue<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.left != null) {
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }
    
    public static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        Node head = generateNode(levelList.poll());
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }
    
    public static Node generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
    
}
