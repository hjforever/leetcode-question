//Given two strings word1 and word2, return the minimum number of steps
//required to make word1 and word2 the same. 
//
// In one step, you can delete exactly one character in either string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make 
//"eat" to "ea".
// 
//
// Example 2: 
//
// 
//Input: word1 = "leetcode", word2 = "etco"
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 and word2 consist of only lowercase English letters. 
// 
// Related Topics 字符串 动态规划 👍 425 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q583DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new Q583DeleteOperationForTwoStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            //求两个字符的公共序列
            //dp
            int m = word1.length();
            int n = word2.length();

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                char c1 = word1.charAt(i-1);
                for (int j = 1; j <= n; j++) {
                    char c2 = word2.charAt(j-1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            int lcs = dp[m][n];
            return (m + n) - 2 * lcs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}