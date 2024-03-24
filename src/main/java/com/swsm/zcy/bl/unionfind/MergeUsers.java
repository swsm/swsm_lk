package com.swsm.zcy.bl.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author liujie
 * @date 2023-07-04
 */
public class MergeUsers {
    
    public static class User {
        public String a;
        public String b;
        public String c;
        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    /**
     * 如果两个user，a字段一样或者b字段一样，或者c字段一样，就认为是一个人
     * 请合并users，返回合并之后的用户数量
     */
    public static int mergeUsers(User[] users) {
        UnionSet<User> unionFind = new UnionSet<>(users);     
        HashMap<String, User> mapA = new HashMap<>();
        HashMap<String, User> mapB = new HashMap<>();
        HashMap<String, User> mapC = new HashMap<>();

        for (User user : users) {
            if (mapA.containsKey(user.a)) {
                unionFind.union(user, mapA.get(user.a));
            } else {
                mapA.put(user.a, user);
            }
            if (mapB.containsKey(user.b)) {
                unionFind.union(user, mapA.get(user.a));
            } else {
                mapB.put(user.b, user);
            }
            if (mapC.containsKey(user.c)) {
                unionFind.union(user, mapC.get(user.c));
            } else {
                mapB.put(user.c, user);
            }
        }
        // 向并查集询问合并之后还剩多少个集合
        return unionFind.getSetNum();
    }



    public static class Node<V> {
        V value;
        public Node(V v){
            value = v;
        }
    }

    public static class UnionSet<V> {
        // V -> 节点，只记录对应关系，永远不更改
        public HashMap<V, Node<V>> nodes;
        // 节点与父节点关系
        public HashMap<Node<V>, Node<V>> parents;
        // 只有一个点，它是代表点，才有记录，值就是它代表几个点也就是集合大小
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(V[] values) {
            for (V value : values) {
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public UnionSet(List<V> values) {
            for (V value : values) {
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 从点cur开始，一直往上找，找到不能再往上的代表点，返回
         */
        public Node<V> findFather(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            // cur头节点， 这里进行 节点指向的扁平化，提高查找最终父节点的效率
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize >= bSetSize) {
                    parents.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                    sizeMap.remove(bHead);
                } else {
                    parents.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                    sizeMap.remove(aHead);
                }
            }
        }
        
        public int getSetNum() {
            return sizeMap.size();
        }
    }
    
    
}
