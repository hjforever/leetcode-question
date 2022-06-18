//You are given an array of words where each word consists of lowercase English
//letters. 
//
// wordA is a predecessor of wordB if and only if we can insert exactly one 
//letter anywhere in wordA without changing the order of the other characters to make 
//it equal to wordB. 
//
// 
// For example, "abc" is a predecessor of "abac", while "cba" is not a 
//predecessor of "bcad". 
// 
//
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, 
//where word1 is a predecessor of word2, word2 is a predecessor of word3, and so 
//on. A single word is trivially a word chain with k == 1. 
//
// Return the length of the longest possible word chain with words chosen from 
//the given list of words. 
//
// 
// Example 1: 
//
// 
//Input: words = ["a","b","ba","bca","bda","bdca"]
//Output: 4
//Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
// 
//
// Example 2: 
//
// 
//Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//Output: 5
//Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", 
//"pcxbc", "pcxbcf"].
// 
//
// Example 3: 
//
// 
//Input: words = ["abcd","dbqca"]
//Output: 1
//Explanation: The trivial word chain ["abcd"] is one of the longest word 
//chains.
//["abcd","dbqca"] is not a valid word chain because the ordering of the 
//letters is changed.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] only consists of lowercase English letters. 
// 
// Related Topics 数组 哈希表 双指针 字符串 动态规划 👍 175 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1048LongestStringChain {
    public static void main(String[] args) {
        Solution solution = new Q1048LongestStringChain().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestStrChain(String[] words) {
            // dp , 最长递增子序列
            Arrays.sort(words, Comparator.comparingInt(String::length));
            int n = words.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int ans = 1;
            // dp(j,i)
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (words[j].length() == words[i].length() - 1 && check(words[j], words[i])) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }

        private boolean check(String a, String b) {
            //双指针
            int i = 0, j = 0;
            while (i < a.length() && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }
            j++;
            while (i < a.length() && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }
            return j == b.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}