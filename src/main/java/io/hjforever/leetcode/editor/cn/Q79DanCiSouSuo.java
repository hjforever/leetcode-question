//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
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
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1077 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q79DanCiSouSuo {
    public static void main(String[] args) {
        Solution solution = new Q79DanCiSouSuo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] vist;

        public boolean exist(char[][] board, String word) {
            int n = board.length;
            int m = board[0].length;
            vist = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //起点
                    boolean result = backTrack(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
            return false;
        }

        //回溯判定
        boolean backTrack(char[][] board, String word, int i, int j, int length) {
            if (board[i][j] != word.charAt(length)) {
                //是否与当前字符相同
                return false;
            } else if (length == word.length() - 1) {
                //查询结果判定
                return true;
            }
            //回溯前
            vist[i][j] = true;

            //控制下一个方格的方向坐标
            //只能在前一个方格基础上，上下左右移动
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int n = board.length;
            int m = board[0].length;
            boolean result = false;

            for (int[] dire : directions) {
                int newi = dire[0] + i;
                int newj = dire[1] + j;
                if (newi < n && newi > -1 && newj > -1 && newj < m) {
                    //是否已访问过
                    if (!vist[newi][newj]) {
                        //dfs
                        boolean flag = backTrack(board, word, newi, newj, length + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            //回溯判定后删除对应的节点
            vist[i][j] = false;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}