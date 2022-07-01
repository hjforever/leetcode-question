//You are given a 2D matrix of size m x n, consisting of non-negative integers.
//You are also given an integer k. 
//
// The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] 
//where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed). 
//
// Find the kᵗʰ largest value (1-indexed) of all the coordinates of matrix. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[5,2],[1,6]], k = 1
//Output: 7
//Explanation: The value of coordinate (0,1) is 5 XOR 2 = 7, which is the 
//largest value.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,2],[1,6]], k = 2
//Output: 5
//Explanation: The value of coordinate (0,0) is 5 = 5, which is the 2nd largest 
//value.
// 
//
// Example 3: 
//
// 
//Input: matrix = [[5,2],[1,6]], k = 3
//Output: 4
//Explanation: The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd 
//largest value. 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 0 <= matrix[i][j] <= 10⁶ 
// 1 <= k <= m * n 
// 
// Related Topics 位运算 数组 分治 矩阵 前缀和 快速选择 堆（优先队列） 👍 91 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q1738FindKthLargestXORCoordinateValue {
    public static void main(String[] args) {
        Solution solution = new Q1738FindKthLargestXORCoordinateValue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            //二维前缀 + 优先堆/排序
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] pre = new int[m + 1][n + 1];
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                    list.add(pre[i][j]);
                }
            }
            Collections.sort(list, (o1, o2) -> o2 - o1);
            return list.get(k - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}