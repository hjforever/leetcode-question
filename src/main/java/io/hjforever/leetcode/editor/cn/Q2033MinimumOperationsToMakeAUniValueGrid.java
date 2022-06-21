//You are given a 2D integer grid of size m x n and an integer x. In one
//operation, you can add x to or subtract x from any element in the grid. 
//
// A uni-value grid is a grid where all the elements of it are equal. 
//
// Return the minimum number of operations to make the grid uni-value. If it is 
//not possible, return -1. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[2,4],[6,8]], x = 2
//Output: 4
//Explanation: We can make every element equal to 4 by doing the following: 
//- Add x to 2 once.
//- Subtract x from 6 once.
//- Subtract x from 8 twice.
//A total of 4 operations were used.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,5],[2,3]], x = 1
//Output: 5
//Explanation: We can make every element equal to 3.
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,2],[3,4]], x = 2
//Output: -1
//Explanation: It is impossible to make every element equal.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 1 <= x, grid[i][j] <= 10⁴ 
// 
// Related Topics 数组 数学 矩阵 排序 👍 26 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2033MinimumOperationsToMakeAUniValueGrid {
    public static void main(String[] args) {
        Solution solution = new Q2033MinimumOperationsToMakeAUniValueGrid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[][] grid, int x) {
            // greedy，取中位数
            int n = grid.length;
            int m = grid[0].length;
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums.add(grid[i][j]);
                }
            }
            Collections.sort(nums);
            //取中位数
            int mid = nums.get(n * m / 2);
            int ans = 0;

            for (int num : nums) {
                int dif = Math.abs(mid - num);
                if (dif % x != 0) return -1;
                ans += dif / x;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}