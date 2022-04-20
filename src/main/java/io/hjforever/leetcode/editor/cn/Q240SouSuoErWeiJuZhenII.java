//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 分治 矩阵 👍 990 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q240SouSuoErWeiJuZhenII {
    public static void main(String[] args) {
        Solution solution = new Q240SouSuoErWeiJuZhenII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // two pointers
            int r = matrix.length;
            int c = matrix[0].length;
            //比对右上角的数字
            int row = 0;
            int col = c - 1;

            while (row < r && col >= 0) {
                int num = matrix[row][col];
                if (num == target) {
                    return true;
                } else if (target > num) {
                    row++;
                } else {
                    col--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}