package com.swsm.zcy.bl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujie
 * @date 2023-06-26
 */
public class MaxHappy {
    
    public static class Employee {
        public int happy;
        public List<Employee> nexts;
        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }
    }

    /**
     * 求员工的来的最大人数
     * 逻辑：
     * 1. 如果当前节点为null，就返回0
     * 2. 进入递归函数，因为是第一个节点，所以它的上层节点选择是false
     * 3. 如果上层节点是true，则当前节点只能是false则进入递归，递归函数的参数 上层节点选择就是false
     * 4. 如果上层节点是false，则当前节点可以是true，也可以是false，有两种可能，则会进入两种递归(true false)计算最大人数
     * 5. 当节点没有后继节点则递归结束
     */
    public static int maxHappy1(Employee boss) {
        if (boss == null) {
            return 0;
        }
        return process1(boss, false);
    }
    
    public static int process1(Employee cur, boolean up) {
        if (up) {
            int ans = 0;
            for (Employee next : cur.nexts) {
                ans += process1(next, false);
            }
            return ans;
        } else {
            int p1 = cur.happy;
            int p2 = 0;
            for (Employee next : cur.nexts) {
                p1 += process1(next, true);
                p2 += process1(next, false);
            }
            return Math.max(p1, p2);
        }
    }

    /**
     * (使用树形bp问题求解方式)求员工的来的最大人数
     * 逻辑：封装每个节点的选择yes no为每个子树的最大人数值
     * 1. 如果当前节点为null则返回0
     * 2. 进入递归函数
     * 3. baseCase 如果节点的nexts是空 则当前结果为Info(x.happy, 0)
     * 4. 定义变量当前选择去yes=x.happy, 当前选择不去no=0
     * 5. 循环处理x.nexts
     * 6. 递归处理每个next节点得到next的nextInfo，
     * 7. 当前节点去yes + 下一节点no 并赋值为yes
     * 8. 取子节点去和不去的最大值 + 当前节点no 给到 no
     * 9. 循环处理 5，直到处理完当前节点的next节点列表
     * 10. 用yes 和 no 构造Info返回
     */
    public static int maxHappy2(Employee boss) {
        if (boss == null) {
            return 0;
        }
        Info all = process2(boss);
        return Math.max(all.yes, all.no);
    }
    
    public static class Info {
        public int yes;
        public int no;
        public Info(int y, int n) {
            yes = y;
            no = n;
        }
    }
    
    public static Info process2(Employee x) {
        if (x.nexts.isEmpty()) {
            return new Info(x.happy, 0);
        }
        int yes = x.happy;
        int no = 0;
        for (Employee next : x.nexts) {
            Info nextInfo = process2(next);
            yes += nextInfo.no;
            no += Math.max(nextInfo.yes, nextInfo.no);
        }
        return new Info(yes, no);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1);
        Employee e2 = new Employee(1);
        Employee e3 = new Employee(1);
        Employee e4 = new Employee(1);
        Employee e5 = new Employee(1);
        Employee e6 = new Employee(1);
        Employee e7 = new Employee(1);
        Employee e8 = new Employee(1);
        Employee e9 = new Employee(1);
        Employee e10 = new Employee(1);
        List e1Nexts = new ArrayList();
        e1Nexts.add(e2);
        e1Nexts.add(e3);
        e1Nexts.add(e4);
        e1.nexts = e1Nexts;
        
        List e2Nexts = new ArrayList();
        e2Nexts.add(e5);
        e2Nexts.add(e6);
        e2.nexts = e2Nexts;

        List e3Nexts = new ArrayList();
        e3Nexts.add(e7);
        e3Nexts.add(e8);
        e3.nexts = e3Nexts;

        List e4Nexts = new ArrayList();
        e4Nexts.add(e9);
        e4Nexts.add(e10);
        e4.nexts = e4Nexts;

        System.out.println(maxHappy1(e1));
        System.out.println(maxHappy2(e1));
    }
    
    
    
}
