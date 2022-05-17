//Given an m x n matrix grid where each cell is either a wall 'W', an enemy 'E'
//or empty '0', return the maximum enemies you can kill using one bomb. You can 
//only place the bomb in an empty cell. 
//
// The bomb kills all the enemies in the same row and column from the planted 
//point until it hits the wall since it is too strong to be destroyed. 
//
// 
// Example 1: 
//
// 
//Input: grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: grid = [["W","W","W"],["0","0","0"],["E","E","E"]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] is either 'W', 'E', or '0'. 
// 
// Related Topics 数组 动态规划 矩阵 👍 80 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q361BombEnemy {
    public static void main(String[] args) {
        Solution solution = new Q361BombEnemy().new Solution();
        solution.maxKilledEnemies(new char[][]{{'E', 'E', 'E'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dfs , prefix sum
        public int maxKilledEnemies(char[][] grid) {
            int r = grid.length;
            int c = grid[0].length;
            int ans = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == '0') {
                        //bomb
                        ans = Math.max(ans, bomb(grid, i, j));
                    }
                }
            }
            return ans;
        }


        int bomb(char[][] grid, int i, int j) {
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;

            int c = j - 1;
            //row
            while (c >= 0 && grid[i][c] != 'W') {
                if (grid[i][c] == 'E') {
                    count++;
                }
                c--;
            }
            c = j + 1;
            while (c < n && grid[i][c] != 'W') {
                if (grid[i][c] == 'E') {
                    count++;
                }
                c++;
            }

            int r = i - 1;
            //col
            while (r >= 0 && grid[r][j] != 'W') {
                if (grid[r][j] == 'E') {
                    count++;
                }
                r--;
            }
            r = i + 1;
            while (r < m && grid[r][j] != 'W') {
                if (grid[r][j] == 'E') {
                    count++;
                }
                r++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}