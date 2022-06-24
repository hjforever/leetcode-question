//English description is not available for the problem. Please switch to
//Chinese. 
// Related Topics 数组 动态规划 👍 43 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOfferII091FenShuaFangZi {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOfferII091FenShuaFangZi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            //dp
            int n = costs.length;
            int[][] dp = new int[n][3];
            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
            }
            return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}