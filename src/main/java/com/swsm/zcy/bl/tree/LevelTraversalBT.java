package com.swsm.zcy.bl.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liujie
 * @date 2023-06-25
 */
public class LevelTraversalBT {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 按层遍历打印二叉树各节点
     * 逻辑：使用queue来完成
     * 1. 如果头节点为空则返回
     * 2. 创建queue，头节点入队列
     * 3. 当队列不为空，执行循环
     * 4. 从队列中取出节点node，打印node的值
     * 5. 如果node的左孩子不为空则左孩子加入队列
     * 6. 如果node的右孩子不为空则右孩子加入队列
     * 7. 继续循环3，当队列为空时，所有节点都按层遍历一遍了
     */
    public static void level(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            } 
            if (node.right != null) {
                queue.add(node.right);    
            }
            
        }
    }
    
    
    
}
