package com.swsm.lik.basic.tree.q3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static com.swsm.lik.basic.tree.q3.IsSymmetric.Build.buildTreeAuto;

/**
 * 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 * 
 * 
 * @author liujie
 * @date 2022/12/7
 */
public class IsSymmetric {
    
    static class Build {
        public static void main(String[] args) {
            Integer[] nodes = new Integer[]{2,97,97,0,47,80,0,-7,0,0,-7};
            TreeNode node = buildTreeAuto(nodes);
            System.out.println(node.val);
        }

        public static TreeNode buildTreeAuto(Integer[] nodes) {
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
        Integer[] nodes = new Integer[]{2,97,97,0,47,80,0,-7,0,0,-7};
        TreeNode treeNode1 = buildTreeAuto(nodes);
        
        Solution solution = new Solution();
        boolean res = solution.isSymmetric(treeNode1);
        System.out.println("res=" + res);
    }
    
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            //从两个子节点开始判断
            return isSymmetricHelper(root.left, root.right);
        }

        public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
            //如果左右子节点都为空，说明当前节点是叶子节点，返回true
            if (left == null && right == null)
                return true;
            //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
            if (left == null || right == null || left.val != right.val)
                return false;
            //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        }

    }
    
    static class SolutionFor {
        public boolean isSymmetric(TreeNode root) {
            //队列
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null)
                return true;
            //左子节点和右子节点同时入队
            queue.add(root.left);
            queue.add(root.right);
            //如果队列不为空就继续循环
            while (!queue.isEmpty()) {
                //每两个出队
                TreeNode left = queue.poll(), right = queue.poll();
                //如果都为空继续循环
                if (left == null && right == null)
                    continue;
                //如果一个为空一个不为空，说明不是对称的，直接返回false
                if (left == null ^ right == null)
                    return false;
                //如果这两个值不相同，也不是对称的，直接返回false
                if (left.val != right.val)
                    return false;
                //这里要记住入队的顺序，他会每两个两个的出队。
                //左子节点的左子节点和右子节点的右子节点同时
                //入队，因为他俩会同时比较。
                //左子节点的右子节点和右子节点的左子节点同时入队，
                //因为他俩会同时比较
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }
            return true;
        }
    }
    
    static class SolutionMine {
        public boolean isSymmetric(TreeNode root) {
            List<TreeNode> cycleList = new ArrayList<>();
            List<TreeNode> levelList = new ArrayList<>();
            if (root != null) {
                levelList.add(root);
            }
            while (!levelList.isEmpty()) {
                for (TreeNode treeNode : levelList) {
                    if (treeNode != null) {
                        cycleList.add(treeNode);
                    }
                }
                levelList.clear();
                for (TreeNode treeNode : cycleList) {
                    levelList.add(treeNode.left);
                    levelList.add(treeNode.right);
                }
                cycleList.clear();
                if (!checkSymmetric(levelList)) {
                    return false;
                }
            }
            
            return true;
        }
        private boolean checkSymmetric(List<TreeNode> list) {
            for (int i = 0; i < list.size(); i++) {
                TreeNode firstNode = list.get(i);
                TreeNode secondNode = list.get(list.size() - i - 1);
                if (firstNode == secondNode) {
                    continue;
                }
                if (firstNode == null && secondNode != null || firstNode != null && secondNode == null) {
                    return false;
                }
                if (!Objects.equals(firstNode.val, secondNode.val)) {
                    return false;
                }
            }
            return true;
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
