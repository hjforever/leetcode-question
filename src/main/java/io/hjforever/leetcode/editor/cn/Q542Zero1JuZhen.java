//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 581 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q542Zero1JuZhen {
    public static void main(String[] args) {
        Solution solution = new Q542Zero1JuZhen().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            if (mat == null || mat.length == 0) return new int[0][0];
            int row = mat.length;
            int col = mat[0].length;
            int[][] res = new int[row][col];
            boolean[][] vist = new boolean[row][col];
            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 0) {
                        queue.add(new int[]{i, j});
                        vist[i][j] = true;
                    }
                }
            }

            int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            while (!queue.isEmpty()) {
                int[] data = queue.poll();
                int i = data[0];
                int j = data[1];
                for (int k = 0; k < directions.length; k++) {
                    int newi = i + directions[k][0];
                    int newj = j + directions[k][1];
                    if (newi < 0 || newi >= row || newj < 0 || newj >= col ||
                            mat[newi][newj] == 0 || vist[newi][newj]) {
                        continue;
                    }
                    res[newi][newj] = res[i][j] + 1;
                    vist[newi][newj] = true;
                    queue.add(new int[]{newi, newj});
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}