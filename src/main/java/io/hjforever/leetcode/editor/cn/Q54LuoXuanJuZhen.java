//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 905 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q54LuoXuanJuZhen {
    public static void main(String[] args) {
        Solution solution = new Q54LuoXuanJuZhen().new Solution();
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.spiralOrder(m);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return new ArrayList<>();
            int rowLen = matrix.length;
            int colLen = matrix[0].length;
            //是否扫描
            boolean[][] vist = new boolean[rowLen][colLen];
            List<Integer> res = new ArrayList<>();
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            //方向
            int row = 0;
            int col = 0;
            int directionIndex = 0;
            for (int i = 1; i <= rowLen * colLen; i++) {
                res.add(matrix[row][col]);
                vist[row][col] = true;
                int nextRow = row + directions[directionIndex][0];
                int nextCol = col + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= rowLen || nextCol < 0
                        || nextCol >= colLen || vist[nextRow][nextCol]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row = row + directions[directionIndex][0];
                col = col + directions[directionIndex][1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}