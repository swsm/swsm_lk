package com.swsm.zcy.bl.heap;

/**
 * @author liujie
 * @date 2023-06-14
 */
public class Heap {


    /**
     * 大根堆(可以使用数组来实现 完全二叉树结构，每棵子树的头节点是子树中最大值，heapinsert heapify)
     * 0-n-1, 当前节点k，其左子节点为2k+1 右子节点为2k+2,父 (k-1)/2,树的高度是logN
     * 1-n,当前节点k，其左子节点为2k,右子节点为2k+1,父k/2,树的高度是logN
     */
    public static class MaxHeap {
        // 存放的数据
        private int[] heap;
        // 数组的最大容量
        private final int limit;
        // 目前的数据个数
        private int heapSize;
        
        public MaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }
        
        public boolean isEmpty() {
            return heapSize == 0;
        }
        
        public boolean isFull() {
            return heapSize == limit;
        }

        /**
         * 加入一个数
         * 1. 当前数据已经达到数组容量则抛出异常
         * 2. 新数据放入堆的第一个空位
         * 3. heapSize++
         * 4. 执行heapInsert(调整大根堆数据)
         * 4.1 判断其父是否比它小，如果小
         * 4.2 交换父和它，并继续4.1，直到其父大于它则停止
         * @param value
         */
        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapSize++;
            heapInsert(heap, heapSize);
        }

        /**
         * 取出最大值，第一个值
         * 1. 取出最大值，第一个值
         * 2. 交换数组的最后一个值到第一个值
         * 3. 进行heapify 调整堆为大根堆
         * 3.1 从第一个节点开始到最后一个结束
         * 3.2 先找左孩子位置，当左孩子存在，判断左孩子的值与右孩子的值谁大，谁大谁下表给新变量largest
         * 3.3 判断当前节点和largest值谁大，谁大谁下标给largest
         * 3.4 如果largest的下标就是当前节点的下表则停止
         * 3.5 否则交换largest和当前节点的值
         * 3.6 largest下标作为新的节点的下标
         * 3.7 用新的节点计算新的左孩子节点位置，继续循环3.2
         * @return
         */
        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }
        
        public static void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }
        
        // 从index位置开始往下看，不断下沉，我的子节点都不比我大，就停，
        // 
        public static void heapify(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                // 左右两个子节点中，谁大谁将下标给 largest
                int largest = (left + 1 < heapSize && arr[left + 1] > arr[left]) ? left + 1 : left;
                // 临时父节点和最大节点谁大 谁给largest
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }
        
        public static void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        
    }
    
    
}
