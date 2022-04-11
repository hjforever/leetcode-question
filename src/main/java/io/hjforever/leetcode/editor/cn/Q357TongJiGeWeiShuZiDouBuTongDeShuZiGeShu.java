//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10ⁿ 。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。 
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：1
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 数学 动态规划 回溯 👍 229 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q357TongJiGeWeiShuZiDouBuTongDeShuZiGeShu {
    public static void main(String[] args) {
        Solution solution = new Q357TongJiGeWeiShuZiDouBuTongDeShuZiGeShu().new Solution();
        solution.countNumbersWithUniqueDigits(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            //排列组合
            // f(0) = 1 ,f(1) = 10 ,  f(2) = 9*9 +f(2) ,f(3) = 9*9*8 + f(2) .....
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                int k = 9;
                for (int j = 1; j < i; j++) {
                    k *= (10 - j);
                }
                dp[i] = k + dp[i - 1];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}