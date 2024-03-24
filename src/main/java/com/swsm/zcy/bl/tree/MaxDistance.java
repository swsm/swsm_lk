package com.swsm.zcy.bl.tree;

/**
 * @author liujie
 * @date 2023-06-26
 */
public class MaxDistance {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 求二叉树上节点之间的最大距离
     * 逻辑：左右两边计算并返回统一结构:Info(最大距离maxDistance，高度height),再左右两边一起考虑返回最后的Info
     * 1. 如果头节点为空则返回Info(0, 0)
     * 2. 递归处理左子树返回左边的Info
     * 3. 递归处理右子树返回右边的Info
     * 4. 左子树的高度右子树高度最大值 + 1 作为整棵树高度
     * 5. 最远距离为：左子树最远距离 右子树最远距离 (左子树的高度+右子树高度+1)的三者最大值
     * 6. 使用整棵树高度和最远距离封装Info返回
     */
    public static int maxDistance2(Node head) {
        return process(head).maxDistance;
    }
    
    public static class Info {
        public int maxDistance;
        public int height;
        public Info(int dis, int h) {
            maxDistance = dis;
            height = h;
        }
    }
    
    public static Info process(Node X) {
        if (X == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), leftInfo.height + rightInfo.height + 1);
        return new Info(maxDistance, height);
    }
    
    
}
