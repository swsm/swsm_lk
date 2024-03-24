package com.swsm.zcy.bl.graph;

import com.swsm.zcy.bl.graph.Graph.Node;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author liujie
 * @date 2023-07-05
 */
public class DFS {
    
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
    
    
    
}
