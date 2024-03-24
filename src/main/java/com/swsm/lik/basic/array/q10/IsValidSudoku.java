package com.swsm.lik.basic.array.q10;

import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = 
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 *
 * 输入：board = 
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *  
 *
 * 提示：
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2f9gg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author liujie
 * @date 2022/11/29
 */
public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] board =
                        {{'5','3','.','.','4','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        Solution solution = new Solution();
        boolean validSudoku = solution.isValidSudoku(board);
        System.out.println("validSudoku=" + validSudoku);
    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            // 每行不重复
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                // 验证行 列
                rowSet.clear();
                columnSet.clear();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (rowSet.contains(board[i][j])) {
                            return false;
                        }
                        rowSet.add(board[i][j]);
                    }
                    if (board[j][i] != '.') {
                        if (columnSet.contains(board[j][i])) {
                            return false;
                        }
                        columnSet.add(board[j][i]);
                    }
                }
            }
            Set<Character> tSet = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tSet.clear();
                    int startRow = i * 3;
                    int startCol = j * 3;
                    char[] val = {
                            board[startRow][startCol],board[startRow][startCol+1] ,board[startRow][startCol+2],
                            board[startRow+1][startCol],board[startRow+1][startCol+1] ,board[startRow+1][startCol+2],
                            board[startRow+2][startCol],board[startRow+2][startCol+1] ,board[startRow+2][startCol+2]
                    };
                    for (char s : val) {
                        if (s != '.' && tSet.contains(s)) {
                            return false;
                        }
                        tSet.add(s); 
                    }
                }
            }
            return true;
        }
    }
    
}
