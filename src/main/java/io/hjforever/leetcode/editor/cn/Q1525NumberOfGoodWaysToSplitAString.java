//You are given a string s.
//
// A split is called good if you can split s into two non-empty strings sleft 
//and sright where their concatenation is equal to s (i.e., sleft + sright = s) and 
//the number of distinct letters in sleft and sright is the same. 
//
// Return the number of good splits you can make in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "aacaba"
//Output: 2
//Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
//("a", "acaba") Left string and right string contains 1 and 3 different 
//letters respectively.
//("aa", "caba") Left string and right string contains 1 and 3 different 
//letters respectively.
//("aac", "aba") Left string and right string contains 2 and 2 different 
//letters respectively (good split).
//("aaca", "ba") Left string and right string contains 2 and 2 different 
//letters respectively (good split).
//("aacab", "a") Left string and right string contains 3 and 1 different 
//letters respectively.
// 
//
// Example 2: 
//
// 
//Input: s = "abcd"
//Output: 1
//Explanation: Split the string as follows ("ab", "cd").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only lowercase English letters. 
// 
// Related Topics 位运算 字符串 动态规划 👍 36 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1525NumberOfGoodWaysToSplitAString {
    public static void main(String[] args) {
        Solution solution = new Q1525NumberOfGoodWaysToSplitAString().new Solution();

        solution.numSplits("aacaba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSplits(String s) {
            // prefix sum
            if (s == null || s.equals("") || s.length() == 1) return 0;
            int n = s.length();
            int[][] pre = new int[n + 1][26];
            int ans = 0;

            for (int i = 0; i < n; i++) {
                int idx = s.charAt(i) - 'a';
                for (int j = 0; j < 26; j++) {
                    if (j == idx) {
                        pre[i + 1][j] = pre[i][j] + 1;
                    } else {
                        pre[i + 1][j] = pre[i][j];
                    }
                }
            }

            for (int i = 0; i < n - 1; i++) {
                int leftCount = count(pre, 0, i);
                int rightCount = count(pre, i + 1, n - 1);
                if (leftCount == rightCount) {
                    ans++;
                }
            }
            return ans;
        }

        int count(int[][] pre, int s, int e) {
            int count = 0;
            for (int i = 0; i < 26; i++) {
                int c = pre[e + 1][i] - pre[s][i];
                if (c > 0) count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}