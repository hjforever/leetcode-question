//Given a string s, return the number of unique palindromes of length three
//that are a subsequence of s. 
//
// Note that even if there are multiple ways to obtain the same subsequence, it 
//is still only counted once. 
//
// A palindrome is a string that reads the same forwards and backwards. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order 
//of the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "aabca"
//Output: 3
//Explanation: The 3 palindromic subsequences of length 3 are:
//- "aba" (subsequence of "aabca")
//- "aaa" (subsequence of "aabca")
//- "aca" (subsequence of "aabca")
// 
//
// Example 2: 
//
// 
//Input: s = "adc"
//Output: 0
//Explanation: There are no palindromic subsequences of length 3 in "adc".
// 
//
// Example 3: 
//
// 
//Input: s = "bbcbaba"
//Output: 4
//Explanation: The 4 palindromic subsequences of length 3 are:
//- "bbb" (subsequence of "bbcbaba")
//- "bcb" (subsequence of "bbcbaba")
//- "bab" (subsequence of "bbcbaba")
//- "aba" (subsequence of "bbcbaba")
// 
//
// 
// Constraints: 
//
// 
// 3 <= s.length <= 10⁵ 
// s consists of only lowercase English letters. 
// 
// Related Topics 哈希表 字符串 前缀和 👍 17 👎 0


package io.hjforever.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1930UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        Solution solution = new Q1930UniqueLength3PalindromicSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPalindromicSubsequence(String s) {
            // string hash
            int n = s.length();
            char[] ch = s.toCharArray();
            int ans = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                char c = ch[i];
                if (set.contains(c)) continue;
                int lidx = s.indexOf(c);
                int ridx = s.lastIndexOf(c);
                if (lidx != -1 && ridx != -1 && ridx - lidx > 1) {
                    Set<Character> cset = new HashSet<>();
                    for (int k = lidx + 1; k < ridx; k++) {
                        cset.add(ch[k]);
                    }
                    ans += cset.size();
                }
                set.add(c);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}