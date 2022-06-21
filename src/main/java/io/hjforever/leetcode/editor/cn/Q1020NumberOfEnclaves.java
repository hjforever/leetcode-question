//You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
// represents a land cell. 
//
// A move consists of walking from one land cell to another adjacent (4-
//directionally) land cell or walking off the boundary of the grid. 
//
// Return the number of land cells in grid for which we cannot walk off the 
//boundary of the grid in any number of moves. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//Output: 3
//Explanation: There are three 1s that are enclosed by 0s, and one 1 that is 
//not enclosed because its on the boundary.
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//Output: 0
//Explanation: All 1s are either on the boundary or can reach the boundary.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] is either 0 or 1. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 177 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1020NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new Q1020NumberOfEnclaves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            //dfs，从边界
            int m = grid.length;
            int n = grid[0].length;
            //遍历左右边界
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1) dfs(grid, i, 0);
                if (grid[i][n - 1] == 1) dfs(grid, i, n - 1);
            }
            for (int i = 0; i < n; i++) {
                if (grid[0][i] == 1) dfs(grid, 0, i);
                if (grid[m - 1][i] == 1) dfs(grid, m - 1, i);
            }
            //统计剩下的1的数目
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) ans++;
                }
            }
            return ans;
        }

        void dfs(int[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) {
                return;
            }
            grid[i][j] = 0;
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}