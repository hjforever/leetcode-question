//A string is considered beautiful if it satisfies the following conditions:
//
// 
// Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least 
//once in it. 
// The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, 
//all 'e's before 'i's, etc.). 
// 
//
// For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, 
//but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful. 
//
// Given a string word consisting of English vowels, return the length of the 
//longest beautiful substring of word. If no such substring exists, return 0. 
//
// A substring is a contiguous sequence of characters in a string. 
//
// 
// Example 1: 
//
// 
//Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
//Output: 13
//Explanation: The longest beautiful substring in word is "aaaaeiiiiouuu" of 
//length 13. 
//
// Example 2: 
//
// 
//Input: word = "aeeeiiiioooauuuaeiou"
//Output: 5
//Explanation: The longest beautiful substring in word is "aeiou" of length 5.
// 
//
// Example 3: 
//
// 
//Input: word = "a"
//Output: 0
//Explanation: There is no beautiful substring, so return 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 5 * 10⁵ 
// word consists of characters 'a', 'e', 'i', 'o', and 'u'. 
// 
// Related Topics 字符串 滑动窗口 👍 27 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1839LongestSubstringOfAllVowelsInOrder {
    public static void main(String[] args) {
        Solution solution = new Q1839LongestSubstringOfAllVowelsInOrder().new Solution();
        System.out.println(solution.longestBeautifulSubstring("auoeioueiaaioeuieuoaieuaoeuoaiaoueioiaeuiuaeouaoie"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestBeautifulSubstring(String word) {
            // sliding window
            int n = word.length();
            if (n < 5) return 0;
            int ans = 0;

            int idx = 1;
            for (int i = 0, j = 1; j < n; j++) {
                if (word.charAt(j) < word.charAt(j - 1)) {
                    i = j;
                    idx = 1;
                } else if (word.charAt(j) > word.charAt(j - 1)) {
                    idx++;
                }
                if (idx == 5) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}