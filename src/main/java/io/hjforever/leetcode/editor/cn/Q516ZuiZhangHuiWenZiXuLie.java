//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 698 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q516ZuiZhangHuiWenZiXuLie {
    public static void main(String[] args) {
        Solution solution = new Q516ZuiZhangHuiWenZiXuLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            //dp(i) = dp(i+1,j-1)+2 && s[i]==s[j]
            //dp(i) = max(dp(i-1,j),dp(i,j-1)) && s[i]!=s[j]

            if (s == null || s.length() == 0) return 0;
            if (s.length() == 1) return 1;
            int n = s.length();
            int[][] dp = new int[n][n];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else {
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        } else {
                            dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                        }
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}