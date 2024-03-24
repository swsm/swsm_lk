package com.swsm.lik.basic.tree.q1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3
 *
 * @author liujie
 * @date 2022/12/6
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        Solution solution = new Solution();
        int res = solution.maxDepth(treeNode1);
        System.out.println("res=" + res);
    }

    /**
     * BFS遍历树(广度优先) 借用Deque来完成
     * 一层层遍历，遍历完一层后，count+1
     * 直到所有层都遍历完，返回count
     */
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            //创建一个队列
            Deque<TreeNode> deque = new LinkedList<>();
            deque.push(root);
            int count = 0;
            while (!deque.isEmpty()) {
                //每一层的个数
                int size = deque.size();
                while (size-- > 0) {
                    TreeNode cur = deque.pop();
                    if (cur.left != null)
                        deque.addLast(cur.left);
                    if (cur.right != null)
                        deque.addLast(cur.right);
                }
                count++;
            }
            return count;
        }
    }


    /**
     * 递归调用，
     * 每一层的左节点和右节点都有其对应的深度，只要取最大的那个就行了
     * 然后一层层向上，最后的那个就是整个二叉树的深度
     */
    static class SolutionComRe {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    /**
     * 递归处理
     */
    static class SolutionMine {
        int max = 0;

        public int maxDepth(TreeNode root) {
            down(root, 0);
            return max;
        }

        public void down(TreeNode node, int high) {
            if (node == null) {
                return;
            }
            if (node != null || node.right != null || node.left != null) {
                high++;
                if (high >= max) {
                    max = high;
                }
            }
            down(node.left, high);
            down(node.right, high);
            return;
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
