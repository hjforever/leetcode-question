//给你一个大小为 m x n 的二进制矩阵 grid 。
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 659 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q695DaoYuDeZuiDaMianJi {
    public static void main(String[] args) {
        Solution solution = new Q695DaoYuDeZuiDaMianJi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int row = grid.length;
            int col = grid[0].length;

            int res = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        int area = bfs(grid, i, j);
                        //System.out.println(area);
                        res = Math.max(area, res);
                    }
                }
            }
            return res;
        }

        int bfs(int[][] grid, int row, int col) {
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{row, col});
            grid[row][col] = 0;
            int area = 0;
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while (!queue.isEmpty()) {
                int[] data = queue.poll();
                int i = data[0];
                int j = data[1];
                area++;
                for (int k = 0; k < directions.length; k++) {
                    int newi = directions[k][0] + i;
                    int newj = directions[k][1] + j;
                    if (newi < 0 || newi >= grid.length
                            || newj < 0 || newj >= grid[0].length || grid[newi][newj] == 0) {
                        continue;
                    }
                    grid[newi][newj] = 0;
                    queue.add(new int[]{newi, newj});
                }
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}