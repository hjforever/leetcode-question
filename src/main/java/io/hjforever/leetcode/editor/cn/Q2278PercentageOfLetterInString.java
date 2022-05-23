//Given a string s and a character letter, return the percentage of characters
//in s that equal letter rounded down to the nearest whole percent. 
//
// 
// Example 1: 
//
// 
//Input: s = "foobar", letter = "o"
//Output: 33
//Explanation:
//The percentage of characters in s that equal the letter 'o' is 2 / 6 * 100% = 
//33% when rounded down, so we return 33.
// 
//
// Example 2: 
//
// 
//Input: s = "jjjj", letter = "k"
//Output: 0
//Explanation:
//The percentage of characters in s that equal the letter 'k' is 0%, so we 
//return 0. 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of lowercase English letters. 
// letter is a lowercase English letter. 
// 
// 👍 1 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2278PercentageOfLetterInString {
    public static void main(String[] args) {
        Solution solution = new Q2278PercentageOfLetterInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int percentageLetter(String s, char letter) {
            // monitor
            int n = s.length();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == letter) {
                    count++;
                }
            }
            return count*100 / n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}