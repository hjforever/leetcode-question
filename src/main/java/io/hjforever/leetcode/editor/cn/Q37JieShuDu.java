//编写一个程序，通过填充空格来解决数独问题。
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 👍 1003 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q37JieShuDu {
    public static void main(String[] args) {
        Solution solution = new Q37JieShuDu().new Solution();
        char[][] b = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solution.solveSudoku(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void solveSudoku(char[][] board) {
            backTrack(board);
        }

        boolean backTrack(char[][] board) {
            if (isFill(board)) {
                return true;
            }
            for (int m = 0; m < 9; m++) {
                for (int n = 0; n < 9; n++) {
                    //填充数字
                    if (board[m][n] == '.') {
                        //获取可以填充的数字
                        List<Character> fillList = fillList(board, m, n);
                        if (fillList == null || fillList.isEmpty()) {
                            return false;
                        }
                        for (char ch : fillList) {
                            board[m][n] = ch;
                            boolean result = backTrack(board);
                            if (result) {
                                return true;
                            }
                            board[m][n] = '.';
                        }
                        //当没有找到任何解时则需要return
                        //关键点，第一次做就遗漏在这里了,导致死循环
                        return false;
                    }
                }
            }
            return true;
        }

        //获取可以填充的list
        List<Character> fillList(char[][] board, int i, int j) {
            List<Character> list = new ArrayList<>();
            Set<Character> set = new HashSet<>();
            //获取已经出现过的数字
            //获取横向
            for (int k = 0; k < board.length; k++) {
                if (board[k][j] != '.') {
                    set.add(board[k][j]);
                }
            }
            //获取竖向
            for (int k = 0; k < board.length; k++) {
                if (board[i][k] != '.') {
                    set.add(board[i][k]);
                }
            }
            //获取方格内
            //先计算是在那一块方格
            int ii = i / 3 + 1;
            int jj = j / 3 + 1;

            int iii = (ii - 1) * 3;
            int jjj = (jj - 1) * 3;

            for (int start = iii; start < iii + 3; start++) {
                for (int end = jjj; end < jjj + 3; end++) {
                    if (board[start][end] != '.') {
                        set.add(board[start][end]);
                    }
                }
            }

            for (char k = '1'; k <= '9'; k++) {
                if (!set.contains(k)) {
                    list.add(k);
                }
            }
            return list;
        }

        //board is fill
        boolean isFill(char[][] board) {
            int n = board.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}