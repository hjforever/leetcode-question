//You are given an m x n integer matrix grid, and three integers row, col, and
//color. Each value in the grid represents the color of the grid square at that 
//location. 
//
// Two squares belong to the same connected component if they have the same 
//color and are next to each other in any of the 4 directions. 
//
// The border of a connected component is all the squares in the connected 
//component that are either 4-directionally adjacent to a square not in the component, 
//or on the boundary of the grid (the first or last row or column). 
//
// You should color the border of the connected component that contains the 
//square grid[row][col] with color. 
//
// Return the final grid. 
//
// 
// Example 1: 
// Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//Output: [[3,3],[3,2]]
// Example 2: 
// Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//Output: [[1,3,3],[2,3,3]]
// Example 3: 
// Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//Output: [[2,2,2],[2,1,2],[2,2,2]]
// 
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 146 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1034ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new Q1034ColoringABorder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            //dfs , mask and printf board
            int m = grid.length, n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            List<int[]> borders = new ArrayList<>();
            int originalColor = grid[row][col];
            visited[row][col] = true;
            dfs(grid, row, col, visited, borders, originalColor);
            for (int i = 0; i < borders.size(); i++) {
                int x = borders.get(i)[0], y = borders.get(i)[1];
                grid[x][y] = color;
            }
            return grid;
        }

        private void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> borders, int originalColor) {
            int m = grid.length, n = grid[0].length;
            boolean isBorder = false;
            int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int i = 0; i < 4; i++) {
                int nx = direc[i][0] + x, ny = direc[i][1] + y;
                if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                    isBorder = true;
                } else if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(grid, nx, ny, visited, borders, originalColor);
                }
            }
            if (isBorder) {
                borders.add(new int[]{x, y});
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}