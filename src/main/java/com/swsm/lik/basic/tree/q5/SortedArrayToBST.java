package com.swsm.lik.basic.tree.q5;

import java.util.concurrent.ArrayBlockingQueue;

import static com.swsm.lik.basic.tree.q5.SortedArrayToBST.Build.buildTreeAuto;


/**
 * 将有序数组转换为二叉搜索树
 * 
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * @author liujie
 * @date 2022/12/7
 */
public class SortedArrayToBST {

    static class Build {
        public static void main(String[] args) {
            int[] nodes = new int[]{2,97,97,0,47,80,0,-7,0,0,-7};
            TreeNode node = buildTreeAuto(nodes);
            System.out.println(node.val);
        }

        public static TreeNode buildTreeAuto(int[] nodes) {
            TreeNode bt;
            ArrayBlockingQueue<Integer> dataQ = new ArrayBlockingQueue(50);
            ArrayBlockingQueue<TreeNode> treeQ = new ArrayBlockingQueue(50);
            for (int i = 0; i < nodes.length; i++) {
                dataQ.add(nodes[i]);
            }
            Integer data = dataQ.poll();
            if (data != 0) {
                bt = new TreeNode(data);
                treeQ.add(bt);
            } else {
                return null;
            }
            while (!treeQ.isEmpty() ) {
                TreeNode t = treeQ.poll();
                data = dataQ.poll();
                if (data == null || data == 0) {
                    t.left = null;
                } else {
                    TreeNode left = new TreeNode(data);
                    t.left = left;
                    treeQ.add(t.left);
                }
                data = dataQ.poll();
                if (data == null || data == 0) {
                    t.right = null;
                } else {
                    TreeNode right = new TreeNode(data);
                    t.right = right;
                    treeQ.add(t.right);
                }
            }
            return bt;
        }
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{-10,-3,0,5,9};
        TreeNode treeNode1 = buildTreeAuto(nodes);

        Solution solution = new Solution();
        TreeNode node = solution.sortedArrayToBST(nodes);
    }


    /**
     * 递归取中间，左边为左子树 右边为右子树
     */
    static class Solution {
        public TreeNode sortedArrayToBST(int[] num) {
            if (num.length == 0)
                return null;
            return sortedArrayToBST(num, 0, num.length - 1);
        }

        public TreeNode sortedArrayToBST(int[] num, int start, int end) {
            if (start > end)
                return null;
            int mid = (start + end) >> 1;
            TreeNode root = new TreeNode(num[mid]);
            root.left = sortedArrayToBST(num, start, mid - 1);
            root.right = sortedArrayToBST(num, mid + 1, end);
            return root;
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
