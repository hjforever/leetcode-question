//You are given an n x n integer matrix. You can do the following operation any
//number of times: 
//
// 
// Choose any two adjacent elements of matrix and multiply each of them by -1. 
// 
//
// Two elements are considered adjacent if and only if they share a border. 
//
// Your goal is to maximize the summation of the matrix's elements. Return the 
//maximum sum of the matrix's elements using the operation mentioned above. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,-1],[-1,1]]
//Output: 4
//Explanation: We can follow the following steps to reach sum equals 4:
//- Multiply the 2 elements in the first row by -1.
//- Multiply the 2 elements in the first column by -1.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
//Output: 16
//Explanation: We can follow the following step to reach sum equals 16:
//- Multiply the 2 last elements in the second row by -1.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 2 <= n <= 250 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 
// Related Topics 贪心 数组 矩阵 👍 11 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1975MaximumMatrixSum {
    public static void main(String[] args) {
        Solution solution = new Q1975MaximumMatrixSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            //greedy
            //思路：统计负数的个数，如果是偶数，
            // 所有数绝对值累加，如果是单数，找到方阵内所有数绝对值的最小值，然后所有绝对值累加-2倍的最小值
            int n = matrix.length;
            int cnt = 0;
            int min = Integer.MAX_VALUE;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] < 0) cnt++;
                    min = Math.min(Math.abs(matrix[i][j]), min);
                    sum += Math.abs(matrix[i][j]);
                }
            }
            if ((cnt & 1) == 1) {
                return sum - 2L * min;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}