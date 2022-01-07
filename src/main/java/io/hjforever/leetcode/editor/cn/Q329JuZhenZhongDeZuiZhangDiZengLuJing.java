//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 574 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q329JuZhenZhongDeZuiZhangDiZengLuJing {
    public static void main(String[] args) {
        Solution solution = new Q329JuZhenZhongDeZuiZhangDiZengLuJing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] diction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            if (row == 1 && col == 1) return 1;

            int res = 0;
            int[][] backUp = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    res = Math.max(dfs(matrix, i, j, backUp), res);
                }
            }
            return res;
        }

        //记忆化搜索
        int dfs(int[][] matrix, int i, int j, int[][] backUp) {
            if (backUp[i][j] != 0) {
                return backUp[i][j];
            }
            backUp[i][j]++;
            int row = matrix.length;
            int col = matrix[0].length;
            for (int k = 0; k < diction.length; k++) {
                int newi = diction[k][0] + i;
                int newj = diction[k][1] + j;
                if (newi < 0 || newi >= row || newj < 0 || newj >= col || matrix[i][j] >= matrix[newi][newj]) {
                    continue;
                }
                int newCount = dfs(matrix, newi, newj, backUp) + 1;
                backUp[i][j] = Math.max(newCount, backUp[i][j]);
            }
            return backUp[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}