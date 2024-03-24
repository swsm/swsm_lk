package com.swsm.zcy.bl.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liujie
 * @date 2023-06-15
 */
public class TrieTree {

    /**
     * 前缀树节点结构
     */
    public static class Node1 {
        // 经过节点的个数
        public int pass;
        // 当前路径结束次数
        public int end;
        // 后继节点数组列表
        public Node1[] nexts;
        public Node1() {
            pass = 0;
            end = 0;
            nexts = new Node1[26];
        }
    }

    /**
     * 前缀树的实现1，用每个节点的后继节点使用数组来实现
     * 逻辑：
     * 1. 构造一颗前缀树，每个字符作为一个节点，在树中存储，且每个节点包含pass和end两个附加信息
     * 2. 插入一个字符串时就构造这个节点树
     * 3. 删除一个字符串就是在树中先遍历通过pass和end来查找是否存在，不存在则不作任何操作存在则遍历改变pass和end的值
     * 4. 查找一个字符串就是在树中遍历通过pass和end来查找
     * 5. 查找前缀数量就是在树中找对应给字符串树中的pass数量
     */
    public static class Trie1 {
        private Node1 root;
        public Trie1 () {
            root = new Node1();
        }

        /**
         * 
         * @param word
         */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) { // 从左往右遍历字符
                index = chs[i] - 'a';              // 由字符，对应成走向哪条路
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }
        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;    
        }
        
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
        
    }
    
    public static class Node2 {
        public int pass;
        public int end;
        // 承载路的载体不一样了，换成hash表
        public HashMap<Integer, Node2> nexts;
        public Node2() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }
    
    public static class Trie2 {
        private Node2 root;
        public Trie2() {
            root = new Node2();
        }
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            Node2 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int)chs[i];
                if (!node.nexts.containsKey(index)) {
                    node.nexts.put(index, new Node2());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }
        
        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                Node2 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = (int)chs[i];
                    if (--node.nexts.get(index).pass == 0) {
                        node.nexts.remove(index);
                        return;
                    }
                    node = node.nexts.get(index);
                }
                node.end--;
            }
        }
        
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int)chs[i];
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.end;
        }
        
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int)chs[i];
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }
    }
    
    public static class Right {
        private HashMap<String, Integer> box;
        public Right() {
            box = new HashMap<>();
        }
        public void insert(String word) {
            if (!box.containsKey(word)) {
                box.put(word, 1);
            } else {
                box.put(word, box.get(word) + 1);
            }
        }
        
        public void delete(String word) {
            Integer value = box.get(word);
            if (value == 1) {
                box.remove(word);
            } else {
                box.put(word, --value);
            }
        }
        
        public int search(String word) {
            if (!box.containsKey(word)) {
                return 0;
            } else {
                return box.get(word);
            }
        }
        
        public int prefixNumber(String pre) {
            int count = 0;
            for (String s : box.keySet()) {
                if (s.startsWith(pre)) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abcrt");
        list.add("acdwd");
        list.add("brtye");
        list.add("aoiue");
        list.add("cuye");
        Trie1 trie1 = new Trie1();
        Trie2 trie2 = new Trie2();
        Right right = new Right();
        for (String str : list) {
            trie1.insert(str);
            trie2.insert(str);
            right.insert(str);
        }

        System.out.println("开始 验证查找是否正确");
        for (String str : list) {
            if (trie1.search(str) != trie2.search(str) 
                    || trie1.search(str) != right.search(str)
                    || trie2.search(str) != right.search(str)) {
                System.out.println(false);
            }
        }
        System.out.println("结束 验证查找是否正确");

        System.out.println("开始 验证找前缀是否正确");
        for (String str : list) {
            if (trie1.prefixNumber(str) != trie2.prefixNumber(str)
                    || trie1.prefixNumber(str) != right.prefixNumber(str)
                    || trie2.prefixNumber(str) != right.prefixNumber(str)) {
                System.out.println(false);
            }
        }
        System.out.println("结束 验证找前缀是否正确");
        
        
        
    }
    
}
