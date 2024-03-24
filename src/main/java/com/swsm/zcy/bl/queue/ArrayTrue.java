package com.swsm.zcy.bl.queue;

/**
 * 使用数组实现队列，注意需要两个指针(putIndex pollIndex)
 * @author liujie
 * @date 2023-06-11
 */
public class ArrayTrue {
    
    // 存放数据的数组
    private int[] arr;
    
    // 放入数据的数组下标
    private int putIndex;
    // 出队列的数组下标
    private int pollIndex;
    // 队列长度
    private int size;
    // 队列大小
    private final int limit;

    public ArrayTrue(int limit) {
        this.limit = limit;
        putIndex = 0;
        pollIndex = 0;
        size = 0;
        arr = new int[limit];
    }

    /**
     * 放入数据
     * 逻辑：
     * 1. 判断是否队列满了，满了则直接抛异常
     * 2. 数组的putIndex放入最新值
     * 3. 数组长度++
     * 4. putIndex 为 计算后的最新值，需要考虑数组循环利用 ++index % limit
     * @param value
     */
    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("队列满了，不能增加了！");
        }
        arr[putIndex] = value;
        size++;
        putIndex = nextIndex(putIndex);
    }

    /**
     * 从队列中弹出值
     * 逻辑：
     * 1. 判断队列是否为空，为空则抛异常
     * 2. 队列数据长度--
     * 3. 值 为 数组的 pollIndex的位置的值
     * 4. pollIndex 重新计算为 新的值，注意数组的循环利用，++index % limit
     * 5. 返回 值
     * @return
     */
    public int poll() {
        if (size == 0) {
            throw new RuntimeException("队列空的，不能取值了！");
        }
        size--;
        int value = arr[pollIndex];
        pollIndex = nextIndex(pollIndex);
        return value;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    private int nextIndex(int index) {
        return ++index % limit;
    }
    


}
