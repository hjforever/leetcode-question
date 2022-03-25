//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
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
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 608 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q74SouSuoErWeiJuZhen {
    public static void main(String[] args) {
        Solution solution = new Q74SouSuoErWeiJuZhen().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            //比对右上节点，大于则往下，小于则往左
            int r = 0;
            int c = col - 1;
            while (r < row && c >= 0) {
                int k = matrix[r][c];
                if (target == k) {
                    return true;
                } else if (target > k) {
                    r++;
                } else {
                    c--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}