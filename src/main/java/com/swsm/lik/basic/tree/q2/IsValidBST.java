package com.swsm.lik.basic.tree.q2;

/**
 * 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 输入：root = [2,1,3]
 * 输出：true
 * 
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 * @author liujie
 * @date 2022/12/6
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(23);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        Solution solution = new Solution();
        boolean res = solution.isValidBST(treeNode1);
        System.out.println("res=" + res);
    }
    
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            Long min = Long.MIN_VALUE;
            Long max = Long.MAX_VALUE;
            return judge(root, min, max);
        }
        
        private boolean judge(TreeNode root, Long min, Long max) {
            if (root == null) {
                return true;
            }
            if (root.val <= min || root.val >= max) {
                return false;
            }
            //这里再分别以左右两个子节点分别判断，
            //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
            //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
            return judge(root.left, min, Long.valueOf(root.val)) && judge(root.right, Long.valueOf(root.val), max);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
}
