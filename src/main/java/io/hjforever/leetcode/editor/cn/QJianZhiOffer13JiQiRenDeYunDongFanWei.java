//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 376 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer13JiQiRenDeYunDongFanWei {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer13JiQiRenDeYunDongFanWei().new Solution();
        System.out.println(solution.count(35, 38));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] vist;

        public int movingCount(int m, int n, int k) {
            vist = new boolean[m][n];
            return backTrack(0, 0, k, m, n);

        }

        //正常的单个回溯会导致重复访问，会超时，此处如果已访问则直接返回0，因为当处于同一块方格时后续的所有走法是固定的，可以剪枝
        int backTrack(int i, int j, int k, int m, int n) {
            if (i >= 0 && i < m && j >= 0 && j < n && !vist[i][j] && count(i, j) <= k) {
                vist[i][j] = true;
                return backTrack(i - 1, j, k, m, n) +
                        backTrack(i + 1, j, k, m, n) +
                        backTrack(i, j - 1, k, m, n) +
                        backTrack(i, j + 1, k, m, n) + 1;
            } else {
                return 0;
            }
        }

        //计算坐标位数和
        int count(int i, int j) {
            int sum = 0;
            while (i / 10 > 0) {
                sum = sum + i % 10;
                i = i / 10;
            }
            sum = sum + i;
            while (j / 10 > 0) {
                sum = sum + j % 10;
                j = j / 10;
            }
            sum = sum + j;
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}