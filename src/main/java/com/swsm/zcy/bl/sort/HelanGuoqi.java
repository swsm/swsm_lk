package com.swsm.zcy.bl.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2023-06-14
 */
public class HelanGuoqi {

    /**
     * 将arr中，L 和 R位置的数排列成，比R小的在左边，跟R一样的在中间，比R大的在右边
     * 犹如 荷兰国旗
     * 逻辑：
     * 1. L R的特殊边界情况进行处理
     * 2. 定义小于指针less在L-1处，大于指针more在R处，当前指针index在L处，后面index指针依次向下移动判断大小后，移动less more，交换数据来完成要求
     * 3. 当index 小于 more时
     * 4. 如果index的位置数 与 R位置数相等，则index++
     * 5. 如果index的位置数 小于 R位置数，则 less++，交换index和less的值，然后index++
     * 6. 如果index的位置数 大于 R位置数，则 more--，交换index和more位置数
     * 7. 循环3 直到index 大于等于more
     * 8. 交换more和R位置的数，让R在相等的那边
     * 9. 返回 相等的区间数组
     */
    public static int[] partition(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        } else if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }
    
    public static void swap(int[] arr, int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 6, 1, 6, 8, 7, 6};
        int[] partition = partition(arr, 0, 8);
        System.out.println(Arrays.toString(partition));
        System.out.println(Arrays.toString(arr));
    }
    
}
