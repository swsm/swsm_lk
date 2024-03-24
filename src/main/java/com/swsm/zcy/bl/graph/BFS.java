package com.swsm.zcy.bl.graph;

import com.swsm.zcy.bl.graph.Graph.Node;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liujie
 * @date 2023-07-05
 */
public class BFS {
    
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // 二叉树没有环，图可能有所以要有这个set结构
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
    
    
}
