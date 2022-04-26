//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
// 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 367 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q417TaiPingYangDaXiYangShuiLiuWenTi {
    public static void main(String[] args) {
        Solution solution = new Q417TaiPingYangDaXiYangShuiLiuWenTi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> res = new ArrayList<>();
            //dfs
            int r = heights.length;
            int c = heights[0].length;

            boolean[][] pacificVist = new boolean[r][c];
            boolean[][] atlanticVist = new boolean[r][c];

            // to atlantic
            for (int i = 0; i < r; i++) {
                // to left
                dfs(i, 0, heights, atlanticVist, heights[i][0]);
            }
            for (int j = 0; j < c; j++) {
                // to bottom
                dfs(0, j, heights, atlanticVist, heights[0][j]);
            }

            //to pacific
            for (int i = 0; i < r; i++) {
                dfs(i, c - 1, heights, pacificVist, heights[i][c - 1]);
            }

            for (int j = 0; j < c; j++) {
                dfs(r - 1, j, heights, pacificVist, heights[r - 1][j]);
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (atlanticVist[i][j] && pacificVist[i][j]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }
                }
            }
            return res;
        }

        void dfs(int x, int y, int[][] heights, boolean[][] vist, int value) {
            int r = heights.length;
            int c = heights[0].length;

            if (x < 0 || y < 0 || x >= r || y >= c || vist[x][y] || heights[x][y]< value ) {
                return;
            }
            int cur = heights[x][y];
            vist[x][y] = true;
            dfs(x + 1, y, heights, vist, cur);
            dfs(x - 1, y, heights, vist, cur);
            dfs(x, y + 1, heights, vist, cur);
            dfs(x, y - 1, heights, vist, cur);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}