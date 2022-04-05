//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4546 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q5ZuiZhangHuiWenZiChuan {
    public static void main(String[] args) {
        Solution solution = new Q5ZuiZhangHuiWenZiChuan().new Solution();
        String s = "abcd";
        System.out.println(s.substring(1, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            //dp(i,j) = dp(i+1,j-1) && s[i] == s[j])
            if (s == null || s.length() == 0) return "";
            int n = s.length();
            if (n < 2) return s;
            int maxLen = 0;
            int left = 0;
            int right = 0;
            boolean[][] dp = new boolean[n][n];
            char[] ch = s.toCharArray();

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        dp[i][j] = true;
                    } else {
                        if (j - i == 1) {
                            dp[i][j] = ch[i] == ch[j];
                        } else {
                            dp[i][j] = ch[i] == ch[j] && dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && maxLen < (j - i + 1)) {
                        maxLen = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
            return s.substring(left, right + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}