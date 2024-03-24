package com.swsm.zcy.bl.graph;

import com.swsm.zcy.bl.graph.Graph.Edge;
import com.swsm.zcy.bl.graph.Graph.Node;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author liujie
 * @date 2023-07-05
 */
public class PrimMST {

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1,Edge o2) {
            return o1.weight - o2.weight;
        }
    }
    
    public static Set<Edge> primMST(Graph graph) {
        // 解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>(); // 依次挑选的边在result里
        for (Node node : graph.nodes.values()) { // 随便挑了一个点
            // node 是开始点
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) { // 由一个点，解锁所有相连的点
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();// 弹出解锁的边中最小的边
                    Node toNode = edge.to;//可能的一个新的点
                    if (!set.contains(toNode)) { // 不含有的时候，就是新的点
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
            break;  // 这里如果break 就可以处理森林来生成多个最小生成树，如果加上break就是没有森林的情况
        }
        return result;
    }
}
