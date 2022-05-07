//给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
//
// 
// 0 表示草地。 
// 1 表示着火的格子。 
// 2 表示一座墙，你跟火都不能通过这个格子。 
// 
//
// 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你
//移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。 
//
// 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，你 总
//是 能到达安全屋，请你返回 10⁹ 。 
//
// 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。 
//
// 如果两个格子有共同边，那么它们为 相邻 格子。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0
//,0,0,0,0,0,0]]
//输出：3
//解释：上图展示了你在初始位置停留 3 分钟后的情形。
//你仍然可以安全到达安全屋。
//停留超过 3 分钟会让你无法安全到达安全屋。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
//输出：-1
//解释：上图展示了你马上开始朝安全屋移动的情形。
//火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
//所以返回 -1 。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
//输出：1000000000
//解释：上图展示了初始网格图。
//注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
//所以返回 10⁹ 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 300 
// 4 <= m * n <= 2 * 10⁴ 
// grid[i][j] 是 0 ，1 或者 2 。 
// grid[0][0] == grid[m - 1][n - 1] == 0 
// 
// Related Topics 广度优先搜索 数组 二分查找 矩阵 👍 12 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q2258TaoLiHuoZai {
    public static void main(String[] args) {
        Solution solution = new Q2258TaoLiHuoZai().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        //二次bfs+二分
        public int maximumMinutes(int[][] grid) {
            //记录初始着火点
            ArrayDeque<int[]> d = new ArrayDeque<>();
            m = grid.length;
            n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1)
                        d.add(new int[]{i, j});
                }
            }

            //二分
            int l = -1, r = m * n;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                //第一次bfs--->二维数组不能clone
                if (correct(grid, new ArrayDeque<>(d), mid))
                    l = mid;
                else r = mid - 1;
            }
            return l == m * n ? (int) 1e9 : l;
        }

        private boolean correct(int[][] grid, Deque<int[]> d, int time) {
            boolean[][] visit = new boolean[m][n];
            //火先烧time时间
            while (time-- > 0 && d.size() > 0)
                //第二次bfs
                spreadFire(grid, visit, d);
            //起点着火或者终点着火
            if (visit[0][0] || visit[m - 1][n - 1])
                return false;

            //判断能否到达终点
            //现在所处的位置
            Deque<int[]> adr = new ArrayDeque<>();
            adr.add(new int[]{0, 0});
            //用于记录已经走过的格子
            boolean[][] used = new boolean[m][n];
            used[0][0] = true;
            while (!adr.isEmpty()) {
                int len = adr.size();
                //先扩散着火-->着火在一个时间，扩散一次
                spreadFire(grid, visit, d);
                while (len-- > 0) {
                    //人在行走
                    int[] p = adr.poll();
                    int x = p[0], y = p[1];
                    for (int[] dir : dirs) {
                        int nx = x + dir[0], ny = y + dir[1];
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == 2 || used[nx][ny])
                            continue;
                        if (nx == m - 1 && ny == n - 1)
                            return true;
                        //当前格子没有着火
                        if (!visit[nx][ny])
                            adr.add(new int[]{nx, ny});
                        used[nx][ny] = true;
                    }
                }
                //火已经烧到房子了
                if (visit[m - 1][n - 1])
                    return false;
            }
            //不能到达终点
            return false;
        }

        //spreadFire--->传播火力-->火力扩散一次
        private void spreadFire(int[][] grid, boolean[][] visit, Deque<int[]> d) {
            int len = d.size();
            while (len-- > 0) {
                int[] p = d.poll();
                int x = p[0], y = p[1];
                visit[x][y] = true;
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || visit[nx][ny] || grid[nx][ny] == 2)
                        continue;
                    d.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}