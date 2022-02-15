//给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
//
// 幸运数是指矩阵中满足同时下列两个条件的元素： 
//
// 
// 在同一行的所有元素中最小 
// 在同一列的所有元素中最大 
// 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
//输出：[15]
//解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//输出：[12]
//解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 3： 
//
// 输入：matrix = [[7,8],[1,2]]
//输出：[7]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= n, m <= 50 
// 1 <= matrix[i][j] <= 10^5 
// 矩阵中的所有元素都是不同的 
// 
// Related Topics 数组 矩阵 👍 82 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1380JuZhenZhongDeXingYunShu {
    public static void main(String[] args) {
        Solution solution = new Q1380JuZhenZhongDeXingYunShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0) return res;

            int m = matrix.length;
            int n = matrix[0].length;

            Set<Integer> rowNums = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int min = matrix[i][0];
                for (int j = 1; j < n; j++) {
                    min = Math.min(min, matrix[i][j]);
                }
                rowNums.add(min);
            }

            for (int j = 0; j < n; j++) {
                int max = matrix[0][j];
                for (int i = 1; i < m; i++) {
                    max = Math.max(matrix[i][j], max);
                }
                if (rowNums.contains(max)) {
                    res.add(max);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}