//Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
//
// 
//
// 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。 
//
// 
// 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母 'k' 。 
// 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。 
// 
//
// 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。 
//
// 
// 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。 
// 
//
// 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：pressedKeys = "22233"
//输出：8
//解释：
//Alice 可能发出的文字信息包括：
//"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
//由于总共有 8 种可能的信息，所以我们返回 8 。
// 
//
// 示例 2： 
//
// 输入：pressedKeys = "222222222222222222222222222222222222"
//输出：82876089
//解释：
//总共有 2082876103 种 Alice 可能发出的文字信息。
//由于我们需要将答案对 10⁹ + 7 取余，所以我们返回 2082876103 % (10⁹ + 7) = 82876089 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pressedKeys.length <= 10⁵ 
// pressedKeys 只包含数字 '2' 到 '9' 。 
// 
// 👍 2 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q6058TongJiDaZiFangAnShu {
    public static void main(String[] args) {
        Solution solution = new Q6058TongJiDaZiFangAnShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTexts(String pressedKeys) {
            //线性dp
            int MOD = (int) (1e9 + 7);
            int n = pressedKeys.length();
            char[] ch = pressedKeys.toCharArray();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1];
                if (i >= 2 && ch[i - 1] == ch[i - 2]) {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
                if (i >= 3 && ch[i - 1] == ch[i - 2] && ch[i - 2] == ch[i - 3]) {
                    dp[i] = (dp[i] + dp[i - 3]) % MOD;
                }
                if (i >= 4 && ch[i - 1] == ch[i - 2] && ch[i - 2] == ch[i - 3] && ch[i - 3] == ch[i - 4] && (ch[i - 1] == '7' || ch[i - 1] == '9')) {
                    dp[i] = (dp[i] + dp[i - 4]) % MOD;
                }
            }
            return dp[n] % MOD;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}