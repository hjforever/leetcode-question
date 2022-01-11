//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 2038 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q72BianJiJuLi {
    public static void main(String[] args) {
        Solution solution = new Q72BianJiJuLi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            // skip     dp[i][j] = dp[i-1][j-1] && w[i]==w[j]

            // delete   dp[i][j]=  dp[i-1][j] +1 ;
            // insert   dp[i][j] = dp[i][j-1] + 1 ;
            // replace  dp[i][j] = dp[i-1][j-1] + 1 ;

            if (word1 == null || word1.length() == 0) return word2 == null ? 0 : word2.length();
            if (word2 == null || word2.length() == 0) return word1 == null ? 0 : word1.length();

            int m = word1.length();
            int n = word2.length();

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i < m + 1; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i < n + 1; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    //skip
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    }
                }
            }

            return dp[m][n];

        }

        int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}