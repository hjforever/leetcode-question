//一个括号字符串是一个 非空 且只包含 '(' 和 ')' 的字符串。如果下面 任意 条件为 真 ，那么这个括号字符串就是 合法的 。
//
// 
// 字符串是 () 。 
// 字符串可以表示为 AB（A 连接 B），A 和 B 都是合法括号序列。 
// 字符串可以表示为 (A) ，其中 A 是合法括号序列。 
// 
//
// 给你一个 m x n 的括号网格图矩阵 grid 。网格图中一个 合法括号路径 是满足以下所有条件的一条路径： 
//
// 
// 路径开始于左上角格子 (0, 0) 。 
// 路径结束于右下角格子 (m - 1, n - 1) 。 
// 路径每次只会向 下 或者向 右 移动。 
// 路径经过的格子组成的括号字符串是 合法 的。 
// 
//
// 如果网格图中存在一条 合法括号路径 ，请返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
//输出：true
//解释：上图展示了两条路径，它们都是合法括号字符串路径。
//第一条路径得到的合法字符串是 "()(())" 。
//第二条路径得到的合法字符串是 "((()))" 。
//注意可能有其他的合法括号字符串路径。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[")",")"],["(","("]]
//输出：false
//解释：两条可行路径分别得到 "))(" 和 ")((" 。由于它们都不是合法括号字符串，我们返回 false 。
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
// grid[i][j] 要么是 '(' ，要么是 ')' 。 
// 
// 👍 4 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q6059JianChaShiFouYouHeFaKuoHaoZiFuChuanLuJing {
    public static void main(String[] args) {
        Solution solution = new Q6059JianChaShiFouYouHeFaKuoHaoZiFuChuanLuJing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean res = false;
        boolean[][][] vis;

        public boolean hasValidPath(char[][] grid) {
            //dfs + 剪枝( '('必须大于')' 数
            int m = grid.length;
            int n = grid[0].length;
            vis = new boolean[m][n][m + n];
            if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
            dfs(grid, 0, 0, m, n, 0);
            return res;
        }

        void dfs(char[][] grid, int i, int j, int m, int n, int cnt) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (vis[i][j][cnt]) return;
            vis[i][j][cnt] = true;
            cnt += grid[i][j] == '(' ? 1 : -1;
            if (cnt < 0 || cnt > (m - i + n - j)) {
                return;
            }
            if (cnt == 0 && i == m - 1 && j == n - 1) {
                res = true;
                return;
            }
            dfs(grid, i + 1, j, m, n, cnt);
            dfs(grid, i, j + 1, m, n, cnt);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}