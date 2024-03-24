package com.swsm.zcy.bl.matrix;

/**
 * @author liujie
 * @date 2023-06-29
 */
public class MatrixZigZag {

    /**
     * 循环打印矩阵
     * 矩阵的题目都不要进行下标的计算，创建指针指向，动指针来处理
     * 逻辑：
     * 1. 创建AR(左上行) AC(左上列) BR(右上行) BC(右上列)
     */
    public static void printMatrixZigZag(int[][] matrix) {
        int AR = 0;
        int AC = 0;
        int BR = 0;
        int BC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false; // 是不是从右上往左下打印
        while (AR != endR + 1) {
            // 告诉斜线的两端，A和B，方向也告诉你
            printLevel(matrix, AR, AC, BR, BC, fromUp);
            AR = AC == endC ? AR + 1 : AR;
            AC = AC == endC ? AC : AC + 1;
            BC = BR == endR ? BC + 1 : BC;
            BR = BR == endR ? BR : BR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }
    
    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.println(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR -1) {
                System.out.println(m[dR--][dC++] + " ");
            }
        }
    }
    
}
