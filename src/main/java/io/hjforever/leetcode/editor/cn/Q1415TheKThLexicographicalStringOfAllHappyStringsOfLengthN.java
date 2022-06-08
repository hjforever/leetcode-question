//A happy string is a string that:
//
// 
// consists only of letters of the set ['a', 'b', 'c']. 
// s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-
//indexed). 
// 
//
// For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings 
//and strings "aa", "baa" and "ababbc" are not happy strings. 
//
// Given two integers n and k, consider a list of all happy strings of length n 
//sorted in lexicographical order. 
//
// Return the kth string of this list or return an empty string if there are 
//less than k happy strings of length n. 
//
// 
// Example 1: 
//
// 
//Input: n = 1, k = 3
//Output: "c"
//Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. 
//The third string is "c".
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 4
//Output: ""
//Explanation: There are only 3 happy strings of length 1.
// 
//
// Example 3: 
//
// 
//Input: n = 3, k = 9
//Output: "cab"
//Explanation: There are 12 different happy string of length 3 ["aba", "abc", 
//"aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will 
//find the 9ᵗʰ string = "cab"
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10 
// 1 <= k <= 100 
// 
// Related Topics 字符串 回溯 👍 35 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1415TheKThLexicographicalStringOfAllHappyStringsOfLengthN {
    public static void main(String[] args) {
        Solution solution = new Q1415TheKThLexicographicalStringOfAllHappyStringsOfLengthN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int cnt = 0;
        StringBuilder s = new StringBuilder();
        String ans;

        public String getHappyString(int n, int k) {
            dfs(n, k);
            return cnt == k ? ans : "";
        }

        void dfs(int n, int k) {
            if (cnt == k) {
                return;
            }
            if (s.length() == n) {
                ans = s.toString();
                cnt++;
                return;
            }
            for (char i = 'a'; i <= 'c'; i++) {
                //剪枝
                if (s.length() > 0 && s.charAt(s.length()- 1 ) == i) {
                    continue;
                }
                s.append("" + i);
                dfs(n, k);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}