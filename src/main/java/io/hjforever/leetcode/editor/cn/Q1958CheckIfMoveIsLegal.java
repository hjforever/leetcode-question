//You are given a 0-indexed 8 x 8 grid board, where board[r][c] represents the
//cell (r, c) on a game board. On the board, free cells are represented by '.', 
//white cells are represented by 'W', and black cells are represented by 'B'. 
//
// Each move in this game consists of choosing a free cell and changing it to 
//the color you are playing as (either white or black). However, a move is only 
//legal if, after changing it, the cell becomes the endpoint of a good line (
//horizontal, vertical, or diagonal). 
//
// A good line is a line of three or more cells (including the endpoints) where 
//the endpoints of the line are one color, and the remaining cells in the middle 
//are the opposite color (no cells in the line are free). You can find examples 
//for good lines in the figure below: 
//
// Given two integers rMove and cMove and a character color representing the 
//color you are playing as (white or black), return true if changing cell (rMove, 
//cMove) to color color is a legal move, or false if it is not legal. 
//
// 
// Example 1: 
//
// 
//Input: board = [[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".
//","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],["W",
//"B","B",".","W","W","W","B"],[".",".",".","B",".",".",".","."],[".",".",".","B",
//".",".",".","."],[".",".",".","W",".",".",".","."]], rMove = 4, cMove = 3, color 
//= "B"
//Output: true
//Explanation: '.', 'W', and 'B' are represented by the colors blue, white, and 
//black respectively, and cell (rMove, cMove) is marked with an 'X'.
//The two good lines with the chosen cell as an endpoint are annotated above 
//with the red rectangles.
// 
//
// Example 2: 
//
// 
//Input: board = [[".",".",".",".",".",".",".","."],[".","B",".",".","W",".",".
//","."],[".",".","W",".",".",".",".","."],[".",".",".","W","B",".",".","."],[".",
//".",".",".",".",".",".","."],[".",".",".",".","B","W",".","."],[".",".",".",".",
//".",".","W","."],[".",".",".",".",".",".",".","B"]], rMove = 4, cMove = 4, color 
//= "W"
//Output: false
//Explanation: While there are good lines with the chosen cell as a middle cell,
// there are no good lines with the chosen cell as an endpoint.
// 
//
// 
// Constraints: 
//
// 
// board.length == board[r].length == 8 
// 0 <= rMove, cMove < 8 
// board[rMove][cMove] == '.' 
// color is either 'B' or 'W'. 
// 
// Related Topics 数组 枚举 矩阵 👍 9 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1958CheckIfMoveIsLegal {
    public static void main(String[] args) {
        Solution solution = new Q1958CheckIfMoveIsLegal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //bfs
        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            return bfs(board, rMove, cMove, color);
        }

        boolean bfs(char[][] board, int i, int j, char originColor) {
            int[][] direct = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
            for (int k = 0; k < direct.length; k++) {
                int[] direction = direct[k];
                if (check(board, i, j, direction, originColor)) {
                    return true;
                }
            }
            return false;
        }

        boolean check(char[][] board, int i, int j, int[] direction, char originColor) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            if (newi < 0 || newj < 0 || newj >= 8 || newi >= 8) return false;
            if (board[newi][newj] == originColor || board[newi][newj] == '.') return false;
            boolean hasEnd = false;
            while (!(newi < 0 || newj < 0 || newj >= 8 || newi >= 8) && board[newi][newj] != '.') {
                if (board[newi][newj] == originColor) {
                    hasEnd = true;
                    break;
                }
                newi = newi + direction[0];
                newj = newj + direction[1];
            }
            return hasEnd;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}