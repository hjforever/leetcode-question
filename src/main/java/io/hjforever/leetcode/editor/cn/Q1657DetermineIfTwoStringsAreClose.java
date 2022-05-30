//Two strings are considered close if you can attain one from the other using
//the following operations: 
//
// 
// Operation 1: Swap any two existing characters.
//
// 
// For example, abcde -> aecdb 
// 
// 
// Operation 2: Transform every occurrence of one existing character into 
//another existing character, and do the same with the other character.
// 
// For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into 
//a's) 
// 
// 
// 
//
// You can use the operations on either string as many times as necessary. 
//
// Given two strings, word1 and word2, return true if word1 and word2 are close,
// and false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "abc", word2 = "bca"
//Output: true
//Explanation: You can attain word2 from word1 in 2 operations.
//Apply Operation 1: "abc" -> "acb"
//Apply Operation 1: "acb" -> "bca"
// 
//
// Example 2: 
//
// 
//Input: word1 = "a", word2 = "aa"
//Output: false
//Explanation: It is impossible to attain word2 from word1, or vice versa, in 
//any number of operations.
// 
//
// Example 3: 
//
// 
//Input: word1 = "cabbba", word2 = "abbccc"
//Output: true
//Explanation: You can attain word2 from word1 in 3 operations.
//Apply Operation 1: "cabbba" -> "caabbb"
//Apply Operation 2: "caabbb" -> "baaccc"
//Apply Operation 2: "baaccc" -> "abbccc"
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 10⁵ 
// word1 and word2 contain only lowercase English letters. 
// 
// Related Topics 哈希表 字符串 排序 👍 31 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q1657DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        Solution solution = new Q1657DetermineIfTwoStringsAreClose().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            //  character count
            if (word1.length() != word2.length()) return false;
            int n = word1.length();
            int[] w1Cnt = new int[26];
            int[] w2Cnt = new int[26];

            for (int i = 0; i < n; i++) {
                w1Cnt[word1.charAt(i) - 'a']++;
                w2Cnt[word2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if ((w1Cnt[i] > 0 && w2Cnt[i] == 0) || (w2Cnt[i] > 0 && w1Cnt[i] == 0)) {
                    return false;
                }
            }
            Arrays.sort(w1Cnt);
            Arrays.sort(w2Cnt);
            for (int i = 0; i < 26; i++) {
                if (w1Cnt[i] != w2Cnt[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}