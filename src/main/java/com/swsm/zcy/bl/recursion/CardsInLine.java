package com.swsm.zcy.bl.recursion;

/**
 * @author liujie
 * @date 2023-07-11
 */
public class CardsInLine {
    
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }
    
    public static int f(int[] arr, int L, int J) {
        if (L == J) {
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L + 1, J), arr[J] + s(arr, L, J - 1));
    }
    
    public static int s(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }
    
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }
        // s[i][i] == 0
        for (int i = 1; i < N; i++) {
            int row = 0;
            int col = i;
            while (row < N && col < N) {
                f[row][col] = Math.max(arr[row] + s[row + 1][ col], arr[col] + s[row][col - 1]);
                s[row][col] = Math.min(f[row + 1][col], f[row][col - 1]);
                
                row++;
                col++;
            }
        }
        
        return Math.max(f[0][N - 1], s[0][N - 1]);
    }
    
    
    
}
