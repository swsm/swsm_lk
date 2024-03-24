package com.swsm.zcy.bl.tree;

/**
 * @author liujie
 * @date 2023-06-26
 */
public class IsBalancedTree {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 判断是否是平衡二叉树(所有左子树和右子树都是平衡二叉树且左子树和右子树高度相差最多为1)
     * 逻辑：左右子树一样返回Info结构体，Info中包含是否平衡，高度数据，最后判断Info数据就可以了
     * 1. 如果头节点为空则返回是平衡的
     * 2. 递归处理头节点的左子树
     * 3. 递归处理头节点的右子树
     * 4. 左子树的高度+右子树的高度+1作为整棵树的高度
     * 5. 如果左子树不是平衡的或者右子树不是平衡的或者左子树和右子树的高度差大于1了，则当前树不是平衡的，否则就是平衡的
     * 6. 用当前树高度和是否平衡构造Info对象返回
     */
    public static boolean isBalanced2(Node head) {
        return process2(head).isBalanced;
    }
    
    
    // 左 右要求一样，Info信息返回的结构体
    public static class Info {
        public boolean isBalanced;
        public int height;
        public Info(boolean b, int h) {
            isBalanced = b;
            height = h;
        }
    }
    
    public static Info process2(Node X) {
        if (X == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(X.left);
        Info rightInfo = process2(X.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if (!leftInfo.isBalanced || rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height) > 1 ) {
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }
    
}
