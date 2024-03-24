package com.swsm.zcy.bl.tree;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liujie
 * @date 2023-06-25
 */
public class BTWidth {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用map计算二叉树的最大宽度(某一层的节点数的最大值)
     * 逻辑：
     * 1. 如果头节点为空则返回0
     * 2. 创建一个queue，头节点先入队列
     * 3. 创建一个代表每个节点在那一层的levelMap
     * 4. 头节点就是 第一层
     * 5. 创建两个变量，当前统计层数 curLevel=1，当前节点所在层数 curLevelNodes=0
     * 6. 创建变量max=0作为当前最大宽度数
     * 7. 当队列不为空时：
     * 8. 从队列获取一个节点cur，从levelMap中获取此节点的层级给到新变量curNodeLevel
     * 9. 如果cur的左孩子不为空，则levelMap中加入左孩子节点，值为curNodeLevel+1,队列压入左孩子
     * 10.如果cur的右孩子不为空，则levelMap中加入右孩子节点，值为curNodeLevel+1，队列压入右孩子
     * 11. 如果curLevel=curNodeLevel, curLevelNodes++，
     * 12. 否则取max和curLevelNodes的最大值给到max
     * 13. curLevel++,curLeveleNodes=1(新的一层开始了)
     * 14. 继续循环7 
     * 15. 最后queue为空，但循环中计算的curLevel还没有和max比较，故还要比较一下大小，返回最大值就是结果
     */
    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1; // 当前统计层数
        int curLevelNodes = 0; //当前节点所在层数
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    /**
     * 不用map计算二叉树的最大宽度(某一层的节点数的最大值)
     * 逻辑：使用当前层最后一个节点curEnd和下一层最右节点nextEnd来辅助处理
     * 1. 如果头节点为空，则返回0
     * 2. 定义队列queue，头节点入队列
     * 3. 定义当前层最后一个节点curEnd=head和下一层最右节点nextEnd=null
     * 4. 定义最大宽度max=0，当前层节点数curLevelNodes=0
     * 5. 当队列不为空，开启while
     * 6. 从队列中取一个值作为cur
     * 7. 如果cur的左孩子不为空，则队列加入左孩子，nextEnd指向左孩子
     * 8. 如果cur的右孩子不为空，则队列加入右孩子，nextEnd指向右孩子
     * 9. 当前层节点数curLevelNodes++
     * 10. 如果cur=curEnd 当前节点走到了当前层的最后一个节点
     * 11. 从max和curLevelNodes中取最大值给到max，curLeveleNodes=0，curEnd = nextEnd
     * 12. 继续循环5, 当前循环完成了当前层的节点数统计并计算出了目前的最大节点数给到max
     * 13. 当队列为空时，所有层节点遍历完毕，返回max
     */
    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(head);
        Node curEnd = head; // 当前层最后一个节点
        Node nextEnd = null; // 如果有下一层的话，下一层最右节点
        int max = 0;
        int curLevelNodes = 0; // 当前层的节点数
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
    
    
}
