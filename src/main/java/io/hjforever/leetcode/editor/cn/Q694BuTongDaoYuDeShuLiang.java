//给定一个非空 01 二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
//
// 请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。 
//
// 
//
// 示例 1： 
//
// 11000
//11000
//00011
//00011
// 
//
// 给定上图，返回结果 1 。 
//
// 示例 2： 
//
// 11011
//10000
//00001
//11011 
//
// 给定上图，返回结果 3 。 
// 
//注意： 
//
// 11
//1
// 
//
// 和 
//
//  1
//11
// 
//
// 是不同的岛屿，因为我们不考虑旋转、翻转操作。 
//
// 
//
// 提示：二维数组每维的大小都不会超过 50 。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 哈希表 哈希函数 👍 104 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q694BuTongDaoYuDeShuLiang {
    public static void main(String[] args) {
        Solution solution = new Q694BuTongDaoYuDeShuLiang().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int numDistinctIslands(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            Set<String> res = new HashSet<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        StringBuilder builder = new StringBuilder();
                        //初始方向随意
                        dfs(grid, i, j, builder, 666);
                        res.add(builder.toString());
                    }
                }
            }
            return res.size();
        }

        void dfs(int[][] grid, int i, int j, StringBuilder sb, int direction) {
            int row = grid.length;
            int col = grid[0].length;
            if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) {
                return;
            }
            //淹没
            grid[i][j] = 0;
            //前置方向
            sb.append(direction).append(',');
            //向四个方向扩散
            dfs(grid, i - 1, j, sb, 1); //上
            dfs(grid, i + 1, j, sb, 2); //下
            dfs(grid, i, j - 1, sb, 3); //左
            dfs(grid, i, j + 1, sb, 4); //右
            // 后序遍历位置：离开 (i, j)
            sb.append(-direction).append(',');
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}