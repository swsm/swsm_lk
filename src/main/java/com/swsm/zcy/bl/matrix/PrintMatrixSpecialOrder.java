package com.swsm.zcy.bl.matrix;

/**
 * @author liujie
 * @date 2023-06-29
 */
public class PrintMatrixSpecialOrder {

    /**
     * 绕圈打印
     * 逻辑：定义4角指针，然后指针变动来打印矩阵位置
     * @param matrix
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--); 
        }
    }
    
    
    public static void printEdge(int[][] m, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.println(m[a][i] + " ");
            } 
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.println(m[i][b] + " ");
            }
        } else {
            int curC = b;
            int curR = a;
            while (curC != d) {
                System.out.println(m[a][curC] + " ");
                curC++;
            }
            while (curR != c) {
                System.out.println(m[curR][d] + " ");
                curR++;
            }
            while (curC != b) {
                System.out.println(m[c][curC] + " ");
                curC--;
            }
            while (curR != a) {
                System.out.println(m[curR][b] + " ");
                curR--;
            }
        }
    }
    
    
    
}
