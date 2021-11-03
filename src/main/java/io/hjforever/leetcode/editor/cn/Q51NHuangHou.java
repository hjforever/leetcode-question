//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 数组 回溯 👍 1068 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q51NHuangHou {
    public static void main(String[] args) {
        Solution solution = new Q51NHuangHou().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new LinkedList<>();

        public List<List<String>> solveNQueens(int n) {
            String[][] q = new String[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    q[i][j] = ".";
            }
            backTrack(n, q, 0);
            return res;
        }

        private void backTrack(int n, String[][] q, int row) {

            //1.退出条件
            if (row >= n) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    StringBuilder builder = new StringBuilder("");
                    for (int i = 0; i < n; i++) {
                        builder.append(q[i][j]);
                    }
                    list.add(builder.toString());
                }
                res.add(list);
                return;
            }

            for (int j = 0; j < n; j++) {
                //排除条件
                if (!validateQ(q, row, j)) {
                    //设置为Q
                    continue;
                }
                q[row][j] = "Q";
                backTrack(n, q, row + 1);
                //回退
                q[row][j] = ".";
            }
        }

        boolean validateQ(String[][] q, int i, int j) {
            int n = q.length;
            for (int h = 0; h < n && h != i; h++) {
                //横向没有皇后
                if (q[h][j] == "Q") {
                    return false;
                }
            }
            //i,j
            //竖向
            for (int h = 0; h < n && h != j; h++) {
                //横向没有皇后
                if (q[i][h] == "Q") {
                    return false;
                }
            }
            //左上移  i,j
            int zi = i;
            int zj = j;
            zi--;
            zj--;
            while (zi >= 0 && zj >= 0) {
                if (q[zi][zj] == "Q") {
                    return false;
                }
                zi--;
                zj--;
            }
            //右上移  i,j
            int yi = i;
            int yj = j;
            yi++;
            yj--;
            while (yi < n && yj >= 0) {
                if (q[yi][yj] == "Q") {
                    return false;
                }
                yi++;
                yj--;

            }
            //左下移
            int zxi = i;
            int zxj = j;
            zxi--;
            zxj++;
            while (zxi >= 0 && zxj < n) {
                if (q[zxi][zxj] == "Q") {
                    return false;
                }
                zxi--;
                zxj++;

            }
            //右下移
            //右上移  i,j
            int yxi = i;
            int yxj = j;
            yxi++;
            yxj++;
            while (yxi < n && yxj < n) {
                if (q[yxi][yxj] == "Q") {
                    return false;
                }
                yxi++;
                yxj++;

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}