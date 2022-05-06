//给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i]
// = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。 
//
// 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，
//那么我们说这个格子被 保卫 了。 
//
// 请你返回空格子中，有多少个格子是 没被保卫 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//输出：7
//解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
//总共有 7 个没有被保卫的格子，所以我们返回 7 。
// 
//
// 示例 2： 
//
// 
//
// 输入：m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
//输出：4
//解释：上图中，没有被保卫的格子用绿色表示。
//总共有 4 个没有被保卫的格子，所以我们返回 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 10⁵ 
// 2 <= m * n <= 10⁵ 
// 1 <= guards.length, walls.length <= 5 * 10⁴ 
// 2 <= guards.length + walls.length <= m * n 
// guards[i].length == walls[j].length == 2 
// 0 <= rowi, rowj < m 
// 0 <= coli, colj < n 
// guards 和 walls 中所有位置 互不相同 。 
// 
// Related Topics 数组 矩阵 模拟 👍 8 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2257TongJiWangGeTuZhongMeiYouBeiBaoWeiDeGeZiShu {
    public static void main(String[] args) {
        Solution solution = new Q2257TongJiWangGeTuZhongMeiYouBeiBaoWeiDeGeZiShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            //bfs
            //需要剪枝
            int[][] room = new int[m][n];
            boolean[][] vis = new boolean[m][n];
            for (int i = 0; i < walls.length; i++) {
                int x = walls[i][0];
                int y = walls[i][1];
                room[x][y] = 2;
            }
            for (int i = 0; i < guards.length; i++) {
                int x = guards[i][0];
                int y = guards[i][1];
                room[x][y] = 1;
            }
            for (int i = 0; i < guards.length; i++) {
                int x = guards[i][0];
                int y = guards[i][1];
                bfs(m, n, x, y, room, vis);
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (room[i][j] == 0 && !vis[i][j]) res++;
                }
            }
            return res;
        }

        void bfs(int m, int n, int x, int y, int[][] room, boolean[][] vis) {
            int col = y;
            col--;
            while (col >= 0 && room[x][col] == 0) {
                vis[x][col] = true;
                col--;
            }
            col = y;
            col++;
            while (col < n && room[x][col] == 0) {
                vis[x][col] = true;
                col++;
            }
            int row = x;
            row--;
            while (row >= 0 && room[row][y] == 0) {
                vis[row][y] = true;
                row--;
            }

            row = x;
            row++;
            while (row < m && room[row][y] == 0) {
                vis[row][y] = true;
                row++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}