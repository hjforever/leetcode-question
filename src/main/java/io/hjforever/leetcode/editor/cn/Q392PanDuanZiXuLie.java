//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
// Related Topics 双指针 字符串 动态规划 👍 573 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q392PanDuanZiXuLie {
    public static void main(String[] args) {
        Solution solution = new Q392PanDuanZiXuLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            //dp[i][26],记录字母出现的下一个位置,若存在则直接跳转至下一个位置
            // d[i][c] = i  && c==t.char(i)
            // dp[i][c] =  dp[i+1][c] && (dp[i][j]存在) && c!=t.char(i);
            if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) return true;
            if (t.length() == 0) return false;
            if (t.length() < s.length()) return false;
            int n = s.length();
            int m = t.length();

            int[][] dp = new int[m + 1][26];
            for (int i = 0; i < 26; i++) {
                //默认初始数字，判断后续字母是否存在，因默认值>实际最大值所以可以判定
                //此处初始化最后一个字符的所有后续字母索引下标
                //临界条件
                dp[m][i] = m;
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < 26; j++) {
                    if (t.charAt(i) == j + 'a') {
                        //表示在当前位置
                        dp[i][j] = i;
                    } else {
                        //转移到下一个字符之后的位置
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
            int index = 0;
            for (int i = 0; i < n; i++) {
                //表示不存在
                if (dp[index][s.charAt(i) - 'a'] == m) {
                    return false;
                }
                //移动至当前字符的位置的下一个位置
                index = dp[index][s.charAt(i) - 'a'] + 1;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}