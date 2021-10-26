//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1479 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q322CoinChange {
    public static void main(String[] args) {
        Solution solution = new Q322CoinChange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 思路一： 递归求解 dp(n) = min(d(n-k)) + 1 ;
         * <p>
         * 思路二： dp
         */
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            //最大值为 amount/1
//            int[] backUp = new int[amount];
//            return coinChangeRecusion(coins, amount, backUp);
            return dp(coins, amount);
        }


        /**
         * 单纯的递归复杂度太高，需要用备忘录模式，避免重复计算
         *
         * @param conins
         * @param amount
         * @return
         */
        private int coinChangeRecusion(int[] conins, int amount, int[] backUp) {
            //确定边界
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            //查询备忘录
            if (backUp[amount - 1] != 0) {
                return backUp[amount - 1];
            }
            Integer minCount = Integer.MAX_VALUE;
            //穷举
            for (int coin : conins) {
                int cnt = coinChangeRecusion(conins, amount - coin, backUp);
                if (cnt == -1) {
                    //表示无解
                    continue;
                }
                if (cnt >= 0 && cnt < minCount) {
                    minCount = cnt + 1;
                }
            }
            //记录备忘录
            backUp[amount - 1] = (minCount == Integer.MAX_VALUE ? -1 : minCount);
            //判断是否有最小值
            return backUp[amount - 1];
        }


        //dp 解法
        private int dp(int[] conins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : conins) {
                    if (i - coin < 0) {
                        //无解
                        continue;
                    }
                    dp[i] = Math.min(dp[i], (1 + dp[i - coin]));
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}