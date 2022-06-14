//Given an m x n matrix mat, return an array of all the elements of the array
//in a diagonal order. 
//
// 
// Example 1: 
//
// 
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,4,7,5,3,6,8,9]
// 
//
// Example 2: 
//
// 
//Input: mat = [[1,2],[3,4]]
//Output: [1,2,3,4]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// Related Topics 数组 矩阵 模拟 👍 315 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q498DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new Q498DiagonalTraverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //mointor
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] res = new int[m * n];
            int pos = 0;
            for (int i = 0; i < m + n - 1; i++) {
                if (i % 2 == 1) {
                    int x = i < n ? 0 : i - n + 1;
                    int y = i < n ? i : n - 1;
                    while (x < m && y >= 0) {
                        res[pos] = mat[x][y];
                        pos++;
                        x++;
                        y--;
                    }
                } else {
                    int x = i < m ? i : m - 1;
                    int y = i < m ? 0 : i - m + 1;
                    while (x >= 0 && y < n) {
                        res[pos] = mat[x][y];
                        pos++;
                        x--;
                        y++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}