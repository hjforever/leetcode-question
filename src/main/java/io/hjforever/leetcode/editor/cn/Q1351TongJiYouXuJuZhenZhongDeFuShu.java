//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
// Related Topics 数组 二分查找 矩阵 👍 90 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1351TongJiYouXuJuZhenZhongDeFuShu {
    public static void main(String[] args) {
        Solution solution = new Q1351TongJiYouXuJuZhenZhongDeFuShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNegatives(int[][] grid) {
            //搜索右上角
            int row = grid.length;
            int col = grid[0].length;

            int res = 0;
            int i = 0;
            int j = col - 1;
            while (i < row && j >= 0) {
                if (grid[i][j] >= 0) {
                    i++;
                } else {
                    j--;
                    //当前行和下面的行数都是小于0
                    res += row - i;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}