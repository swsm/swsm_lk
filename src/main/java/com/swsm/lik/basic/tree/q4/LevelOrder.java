package com.swsm.lik.basic.tree.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

import static com.swsm.lik.basic.tree.q4.LevelOrder.Build.buildTreeAuto;

/**
 * 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 
 * 输入：root = [1]
 * 输出：[[1]]
 * @author liujie
 * @date 2022/12/7
 */
public class LevelOrder {

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
        List<List<Integer>> lists = solution.levelOrder(treeNode1);
        for (List<Integer> list : lists) {
            System.out.print("res=" + Arrays.toString(list.toArray()));
        }
    }


    static class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            levelHelper(res, root, 0);
            return res;
        }

        public void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
            //边界条件判断
            if (root == null)
                return;
            //level表示的是层数，如果level >= list.size()，说明到下一层了，所以
            //要先把下一层的list初始化，防止下面add的时候出现空指针异常
            if (level >= list.size()) {
                list.add(new ArrayList<>());
            }
            //level表示的是第几层，这里访问到第几层，我们就把数据加入到第几层
            list.get(level).add(root.val);
            //当前节点访问完之后，再使用递归的方式分别访问当前节点的左右子节点
            levelHelper(list, root.left, level + 1);
            levelHelper(list, root.right, level + 1);
        }

        public List<List<Integer>> levelOrderFor(TreeNode root) {
            //边界条件判断
            if (root == null)
                return new ArrayList<>();
            //队列
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            //根节点入队
            queue.add(root);
            //如果队列不为空就继续循环
            while (!queue.isEmpty()) {
                //BFS打印，levelNum表示的是每层的结点数
                int levelNum = queue.size();
                //subList存储的是每层的结点值
                List<Integer> subList = new ArrayList<>();
                for (int i = 0; i < levelNum; i++) {
                    //出队
                    TreeNode node = queue.poll();
                    subList.add(node.val);
                    //左右子节点如果不为空就加入到队列中
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                //把每层的结点值存储在res中，
                res.add(subList);
            }
            return res;
        }
        
        public List<List<Integer>> levelOrderMine(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            
            List<TreeNode> levelList = new ArrayList<>();
            if (root != null) {
                levelList.add(root);
            }
            List<TreeNode> cycleList = new ArrayList<>();
            while (!levelList.isEmpty()) {
                for (TreeNode treeNode : levelList) {
                    if (treeNode != null) {
                        cycleList.add(treeNode);
                    }
                }
                if (!cycleList.isEmpty()) {
                    res.add(cycleList.stream().map(a -> a.val).collect(Collectors.toList()));
                }
                levelList.clear();
                for (TreeNode treeNode : cycleList) {
                    levelList.add(treeNode.left);
                    levelList.add(treeNode.right);
                }
                cycleList.clear();
            }
            return res;
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
