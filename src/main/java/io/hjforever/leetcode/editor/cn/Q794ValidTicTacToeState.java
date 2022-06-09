//Given a Tic-Tac-Toe board as a string array board, return true if and only if
//it is possible to reach this board position during the course of a valid tic-
//tac-toe game. 
//
// The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. 
//The ' ' character represents an empty square. 
//
// Here are the rules of Tic-Tac-Toe: 
//
// 
// Players take turns placing characters into empty squares ' '. 
// The first player always places 'X' characters, while the second player 
//always places 'O' characters. 
// 'X' and 'O' characters are always placed into empty squares, never filled 
//ones. 
// The game ends when there are three of the same (non-empty) character filling 
//any row, column, or diagonal. 
// The game also ends if all squares are non-empty. 
// No more moves can be played if the game is over. 
// 
//
// 
// Example 1: 
//
// 
//Input: board = ["O  ","   ","   "]
//Output: false
//Explanation: The first player always plays "X".
// 
//
// Example 2: 
//
// 
//Input: board = ["XOX"," X ","   "]
//Output: false
//Explanation: Players take turns making moves.
// 
//
// Example 3: 
//
// 
//Input: board = ["XOX","O O","XOX"]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// board.length == 3 
// board[i].length == 3 
// board[i][j] is either 'X', 'O', or ' '. 
// 
// Related Topics 数组 字符串 👍 111 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q794ValidTicTacToeState {
    public static void main(String[] args) {
        Solution solution = new Q794ValidTicTacToeState().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validTicTacToe(String[] board) {
            //题意实在难以理解，出题人的语文是数学老师教的
            //题意是看棋盘是否是正常对弈出来的，不是按当前局面开始对弈
            //1. 'x' , 'o' 数量最多相差1
            //2. 'x'获胜则'x'='o'+1
            //3. 'o'获胜则'o'='x'
            //4. 不存在同时两个人获胜的局面

            int xCnt = 0;
            int oCnt = 0;
            for (int i = 0; i < board.length; i++) {
                char[] ch = board[i].toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    if (ch[j] == 'X') xCnt++;
                    if (ch[j] == 'O') oCnt++;
                }
            }
            return !((oCnt != xCnt && oCnt != xCnt - 1) || (oCnt != xCnt - 1 && win(board, 'X')) || (oCnt != xCnt && win(board, 'O')));
        }

        public boolean win(String[] board, char p) {
            for (int i = 0; i < 3; ++i) {
                if ((p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) || (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2))) {
                    return true;
                }
            }
            return ((p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) || (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}