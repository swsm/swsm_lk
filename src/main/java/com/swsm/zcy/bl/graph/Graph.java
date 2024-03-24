package com.swsm.zcy.bl.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author liujie
 * @date 2023-07-04
 */
public class Graph {
    
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    /**
     * matrix 所有的边
     * N*3的矩阵
     * [from, to, weight]
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from  = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
    
    
    
    
    
    

    // 点结构
    public static class Node {
        // 点的值或id
        public int value;
        // 入度
        public int in;
        // 出度
        public int out;
        // 出发经过一条边到达的节点
        public ArrayList<Node> nexts;
        // 出发的边的集合
        public ArrayList<Edge> edges;
        
        public Node (int value) {
            this.value = value;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<>();
            this.edges = new ArrayList<Edge>();
        }
    }
    
    public static class Edge {
        // 边的权重
        public int weight;
        // 起始节点
        public Node from;
        // 结束节点
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }
}
