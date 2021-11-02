//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 214 👎 0


package io.hjforever.leetcode.editor.cn;

class QJianZhiOffer10IIQingWaTiaoTaiJieWenTi {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer10IIQingWaTiaoTaiJieWenTi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {
            //dp ,dp(0)=0 dp(1)= 1 ,dp(2)=2 dp(i) = dp(i-1) + dp(i-2)
            if (n == 0) return 1;
            if (n == 1) return 1;
            if (n == 2) return 2;

            int dp1 = 2;
            int dp2 = 1;
            int dp = 0;
            for (int i = 3; i <= n; i++) {
                dp = (dp1 + dp2) % 1000000007;
                dp2 = dp1;
                dp1 = dp;
            }
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}