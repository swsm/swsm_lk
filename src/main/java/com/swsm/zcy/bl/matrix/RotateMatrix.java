package com.swsm.zcy.bl.matrix;

/**
 * @author liujie
 * @date 2023-06-29
 */
public class RotateMatrix {

    /**
     * 旋转矩阵
     * 逻辑：4角节点，交换对应位置完成旋转
     */
    public static void rotate(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length -1;
        while (a < c) {
            rotateEdge(matrix, a++, b++, c--, d--);
        }
    }

    private static void rotateEdge(int[][] m, int a, int b, int c, int d) {
        int tmp = 0;
        for (int i = 0; i < d - b; i++) {
            tmp = m[a][b + i];
            m[a][b + i] = m [c - i][b];
            m[c - i][b] = m[c][d - i];
            m[c][d - i] = m[a - i][d];
            m[a + i][d] = tmp;
        }
    }


}
