//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 446 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer12JuZhenZhongDeLuJing {

    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer12JuZhenZhongDeLuJing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] vist;

        public boolean exist(char[][] board, String word) {
            //回溯
            vist = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean resutl = backTrack(board, 1, word, i, j);
                        if (resutl) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean backTrack(char[][] board, int pos, String word, int i, int j) {
            char ch = word.charAt(pos - 1);
            if (board[i][j] == ch && !vist[i][j]) {
                if (pos == word.length()) {
                    return true;
                }
                vist[i][j] = true;
                int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
                for (int k = 0; k < dirs.length; k++) {
                    int newi = i + dirs[k][0];
                    int newj = j + dirs[k][1];
                    if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length && !vist[newi][newj]) {
                        boolean result = backTrack(board, pos + 1, word, newi, newj);
                        if (result) {
                            return true;
                        }
                    }
                }
                vist[i][j] = false;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}