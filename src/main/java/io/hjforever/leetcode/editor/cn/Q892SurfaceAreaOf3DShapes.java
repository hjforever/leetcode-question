//You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. Each
//value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j). 
//
//
// After placing these cubes, you have decided to glue any directly adjacent 
//cubes to each other, forming several irregular 3D shapes. 
//
// Return the total surface area of the resulting shapes. 
//
// Note: The bottom face of each shape counts toward its surface area. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[1,2],[3,4]]
//Output: 34
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
//Output: 32
// 
//
// Example 3: 
//
// 
//Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
//Output: 46
// 
//
// 
// Constraints: 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 几何 数组 数学 矩阵 👍 160 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q892SurfaceAreaOf3DShapes {
    public static void main(String[] args) {
        Solution solution = new Q892SurfaceAreaOf3DShapes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int surfaceArea(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int cnt = 0;
            int faces = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    cnt += grid[i][j];
                    if (grid[i][j] > 0) {
                        //堆叠面积
                        faces += (grid[i][j] - 1);
                    }
                    if (i > 0) {
                        //与上边接触的面积
                        faces += Math.min(grid[i - 1][j], grid[i][j]);
                    }
                    if (j > 0) {
                        //与左边接触的面积
                        faces += Math.min(grid[i][j - 1], grid[i][j]);
                    }
                }
            }
            return cnt * 6 - 2 * faces;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}