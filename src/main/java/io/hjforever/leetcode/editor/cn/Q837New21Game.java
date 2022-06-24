//Alice plays the following game, loosely based on the card game "21".
//
// Alice starts with 0 points and draws numbers while she has less than k 
//points. During each draw, she gains an integer number of points randomly from the 
//range [1, maxPts], where maxPts is an integer. Each draw is independent and the 
//outcomes have equal probabilities. 
//
// Alice stops drawing numbers when she gets k or more points. 
//
// Return the probability that Alice has n or fewer points. 
//
// Answers within 10⁻⁵ of the actual answer are considered accepted. 
//
// 
// Example 1: 
//
// 
//Input: n = 10, k = 1, maxPts = 10
//Output: 1.00000
//Explanation: Alice gets a single card, then stops.
// 
//
// Example 2: 
//
// 
//Input: n = 6, k = 1, maxPts = 10
//Output: 0.60000
//Explanation: Alice gets a single card, then stops.
//In 6 out of 10 possibilities, she is at or below 6 points.
// 
//
// Example 3: 
//
// 
//Input: n = 21, k = 17, maxPts = 10
//Output: 0.73278
// 
//
// 
// Constraints: 
//
// 
// 0 <= k <= n <= 10⁴ 
// 1 <= maxPts <= 10⁴ 
// 
// Related Topics 数学 动态规划 滑动窗口 概率与统计 👍 343 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q837New21Game {
    public static void main(String[] args) {
        Solution solution = new Q837New21Game().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double new21Game(int n, int k, int w) {
            //dp
            //f(n)=f(n-1)/w + f(n-2)/w + ... + f(n-w)/w
            double[] dp = new double[n + k + w + 1];
            for (int i = 0; i < k; i++) dp[i] = 0;
            // 将能赢得游戏的点数的概率设置为 1
            for (int i = k; i <= n; i++) dp[i] = 1;
            double num = 0;
            for (int i = k; i <= k + w - 1; i++) num += dp[i];
            for (int i = k - 1; i >= 0; i--) {
                // 点数为 i 的赢得游戏的概率为 i + 1 ~ i + W 的概率和除以 W
                dp[i] = num / w;
                num -= dp[i + w];
                num += dp[i];
            }
            return dp[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}