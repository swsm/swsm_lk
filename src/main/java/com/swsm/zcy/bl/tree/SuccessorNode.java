package com.swsm.zcy.bl.tree;

/**
 * @author liujie
 * @date 2023-06-25
 */
public class SuccessorNode {

    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 中序遍历，返回指定节点的后继节点
     * 逻辑：
     * 情况：
     * 1. 如果当前节点右节点不为空，则找其右子树的最左节点就是其后继节点
     * 2. 如果当前节点是其父有孩子则一直向上直到找到它是其父的左孩子时返回其父节点
     * 
     * @param node
     * @return
     */
    public static Node getSuccessNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            // 找右树的最左节点
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) { 
                // 当前节点是其父亲的右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
    
    public static Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    
}
