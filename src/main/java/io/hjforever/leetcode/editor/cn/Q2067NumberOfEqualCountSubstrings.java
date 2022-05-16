//You are given a 0-indexed string s consisting of only lowercase English
//letters, and an integer count. A substring of s is said to be an equal count 
//substring if, for each unique letter in the substring, it appears exactly count times in 
//the substring. 
//
// Return the number of equal count substrings in s. 
//
// A substring is a contiguous non-empty sequence of characters within a string.
// 
//
// 
// Example 1: 
//
// 
//Input: s = "aaabcbbcc", count = 3
//Output: 3
//Explanation:
//The substring that starts at index 0 and ends at index 2 is "aaa".
//The letter 'a' in the substring appears exactly 3 times.
//The substring that starts at index 3 and ends at index 8 is "bcbbcc".
//The letters 'b' and 'c' in the substring appear exactly 3 times.
//The substring that starts at index 0 and ends at index 8 is "aaabcbbcc".
//The letters 'a', 'b', and 'c' in the substring appear exactly 3 times.
// 
//
// Example 2: 
//
// 
//Input: s = "abcd", count = 2
//Output: 0
//Explanation:
//The number of times each letter appears in s is less than count.
//Therefore, no substrings in s are equal count substrings, so return 0.
// 
//
// Example 3: 
//
// 
//Input: s = "a", count = 5
//Output: 0
//Explanation:
//The number of times each letter appears in s is less than count.
//Therefore, no substrings in s are equal count substrings, so return 0 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁴ 
// 1 <= count <= 3 * 10⁴ 
// s consists only of lowercase English letters. 
// 
// Related Topics 字符串 计数 前缀和 👍 1 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2067NumberOfEqualCountSubstrings {
    public static void main(String[] args) {
        Solution solution = new Q2067NumberOfEqualCountSubstrings().new Solution();
        System.out.println(solution.equalCountSubstrings("aaabcbbcc", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalCountSubstrings(String s, int count) {
            int[][] pre = new int[s.length() + 1][26];
            int n = s.length();
            // prefix sum
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                int idx = c - 'a';
                for (int k = 0; k < 26; k++) {
                    if (idx == k) {
                        pre[i + 1][k] = pre[i][k] + 1;
                    } else {
                        pre[i + 1][k] = pre[i][k];
                    }
                }
            }
            int k = count;
            int res = 0;
            for (int i = k; i <= n; i += k) {
                //此处长度必须在 k-26*k之间，超过则必然有重复
                //此处是重要的剪枝
                if (i > 26 * k) {
                    break;
                }
                for (int j = 0; j < n - i + 1; j++) {
                    //System.out.println(s.substring(j, j + i));
                    if (check(j, j + i - 1, pre, k)) {
                        res++;
                    }
                }
            }
            return res;
        }

        boolean check(int s, int e, int[][] pre, int k) {
            for (int i = 0; i < 26; i++) {
                int count = pre[e + 1][i] - pre[s][i];
                if (count > 0 && count != k) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}