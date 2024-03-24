package com.swsm.zcy.bl.tree;

/**
 * @author liujie
 * @date 2023-06-26
 */
public class MaxSubBst {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    
    public static class Info {
        public boolean isBST;
        public int maxSubBSTSize;
        public int min;
        public int max;
        
        public Info(boolean is, int size, int min, int max) {
            isBST = is;
            maxSubBSTSize = size;
            this.min = min;
            this.max = max;
        }
    }
    
    public static Info process(Node X) {
        if (X == null) {
            return null;
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        int min = X.value;
        int max = X.value;
        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBSTSize = Math.max(maxSubBSTSize, leftInfo.maxSubBSTSize);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }
        boolean isBST = false;
        if ((leftInfo == null ? true : (leftInfo.isBST && leftInfo.max < X.value)
        && (rightInfo == null ? true : (rightInfo.isBST && rightInfo.min > X.value)))) {
            isBST = true;
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
        }
        
        return new Info(isBST, maxSubBSTSize, min, max);
        
    }
    
    
}
