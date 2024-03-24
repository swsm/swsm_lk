package com.swsm.lik.basic.sortandsearch.q2;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * @author liujie
 * @date 2022/12/8
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        Solution solution  = new Solution();
        int res = solution.firstBadVersion(4);
        System.out.println("res=" + res);
    }
    
    static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 0;
            int right = n;
            int i = (right - left) / 2;
            int temp;
            while (i > 0) {
                boolean isBad = isBadVersion(i);
                if (isBad) {
                    right = i;
                } else {
                    left = i;
                }
                temp = left + (right - left) / 2;
                if (i == temp) {
                    break;
                }
                i = temp;
            }
            return right;
        }

        public int firstBadVersionMine(int n) {
            int left = 0;
            int right = n;
            int i = (right - left) / 2;
            int temp;
            while (i > 0) {
                boolean isBad = isBadVersion(i);
                if (isBad) {
                    right = i;
                    i = (right - left) / 2;
                } else {
                    left = i;
                    temp = i + (right - left) / 2;
                    if (temp == i) {
                        break;
                    }
                    i = temp;
                }
            }
            return right;
        }
    }
    
    static class VersionControl {
        public boolean isBadVersion(int n) {
            return true;
        }
    }
    
}
