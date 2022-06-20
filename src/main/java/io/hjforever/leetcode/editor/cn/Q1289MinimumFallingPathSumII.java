//Given an n x n integer matrix grid, return the minimum sum of a falling path
//with non-zero shifts. 
//
// A falling path with non-zero shifts is a choice of exactly one element from 
//each row of grid such that no two elements chosen in adjacent rows are in the 
//same column. 
//
// 
// Example 1: 
//
// 
//Input: arr = [[1,2,3],[4,5,6],[7,8,9]]
//Output: 13
//Explanation: 
//The possible falling paths are:
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//The falling path with the smallest sum is [1,5,7], so the answer is 13.
// 
//
// Example 2: 
//
// 
//Input: grid = [[7]]
//Output: 7
// 
//
// 
// Constraints: 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
// Related Topics 数组 动态规划 矩阵 👍 70 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q1289MinimumFallingPathSumII {
    public static void main(String[] args) {
        Solution solution = new Q1289MinimumFallingPathSumII().new Solution();
        solution.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            // 线性dp
            int n = grid.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = grid[0][i];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j != k) {
                            dp[i][j] = Math.min(grid[i][j] + dp[i - 1][k], dp[i][j]);
                        }
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, dp[n - 1][i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}