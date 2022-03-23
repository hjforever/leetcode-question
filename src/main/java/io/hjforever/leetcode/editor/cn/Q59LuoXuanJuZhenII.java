//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 637 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q59LuoXuanJuZhenII {
    public static void main(String[] args) {
        Solution solution = new Q59LuoXuanJuZhenII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            //数组模拟
            int[][] res = new int[n][n];
            int[][] dirction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            boolean[][] vist = new boolean[n][n];
            int row = 0;
            int col = 0;
            int index = 0;
            int k = 1;
            while (k <= n * n) {
                res[row][col] = k++;
                vist[row][col] = true;
                int nextRow = row + dirction[index][0];
                int nextCol = col + dirction[index][1];
                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n || vist[nextRow][nextCol]) {
                    index = (index + 1) % 4;
                }
                row += dirction[index][0];
                col += dirction[index][1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}