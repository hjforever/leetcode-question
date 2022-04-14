//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 772 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q130BeiWeiRaoDeQuYu {
    public static void main(String[] args) {
        Solution solution = new Q130BeiWeiRaoDeQuYu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // vist
        boolean[][] vist;

        public void solve(char[][] board) {
            //dfs
            //从边开始查找
            int row = board.length;
            int col = board[0].length;
            vist = new boolean[row][col];

            // row
            for (int i = 0; i < col; i++) {
                char top = board[0][i];
                if (top == 'O') {
                    dfs(board, 0, i);
                }
                char bottom = board[row - 1][i];
                if (bottom == 'O') {
                    dfs(board, row - 1, i);
                }
            }
            // col
            for (int i = 0; i < row; i++) {
                char top = board[i][0];
                if (top == 'O') {
                    dfs(board, i, 0);
                }
                char bottom = board[i][col - 1];
                if (bottom == 'O') {
                    dfs(board, i, col - 1);
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (vist[i][j]) {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }

        }

        void dfs(char[][] board, int i, int j) {
            int row = board.length;
            int col = board[0].length;
            if (i < 0 || j < 0 || i >= row || j >= col || vist[i][j] || board[i][j] != 'O') {
                return;
            }
            vist[i][j] = true;
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}