package com.swsm.zcy.bl.tree;

/**
 * @author liujie
 * @date 2023-06-25
 */
public class PaperFolding {

    /**
     * 折纸打印
     * 逻辑：中序遍历平衡二叉树，且此树的规律是头凹左凹右凸
     * 1. 折n次，当前第i次，如果i>n就返回
     * 2. 递归进行第i+1次，因为是中序遍历所以左 true
     * 3. 打印 
     * 4. 递归进行第i+1次，因为是中序遍历所以 右 false
     */
    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }
    
}
