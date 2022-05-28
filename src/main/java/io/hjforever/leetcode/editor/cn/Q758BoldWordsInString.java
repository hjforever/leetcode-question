//Given an array of keywords words and a string s, make all appearances of all
//keywords words[i] in s bold. Any letters between <b> and </b> tags become bold. 
//
// Return s after adding the bold tags. The returned string should use the 
//least number of tags possible, and the tags should form a valid combination. 
//
// 
// Example 1: 
//
// 
//Input: words = ["ab","bc"], s = "aabcd"
//Output: "a<b>abc</b>d"
//Explanation: Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, 
//so it is incorrect.
// 
//
// Example 2: 
//
// 
//Input: words = ["ab","cb"], s = "aabcd"
//Output: "a<b>ab</b>cd"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// 0 <= words.length <= 50 
// 1 <= words[i].length <= 10 
// s and words[i] consist of lowercase English letters. 
// 
//
// 
// Note: This question is the same as 616: https://leetcode.com/problems/add-
//bold-tag-in-string/ 
// Related Topics 字典树 数组 哈希表 字符串 字符串匹配 👍 43 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q758BoldWordsInString {
    public static void main(String[] args) {
        Solution solution = new Q758BoldWordsInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String boldWords(String[] words, String S) {
            boolean[] isBold = new boolean[S.length()];
            for (String word : words) {
                int n = S.indexOf(word, 0);
                while (n != -1) {
                    for (int i = n; i < n + word.length(); i++) isBold[i] = true;
                    n = S.indexOf(word, n + 1);
                }
            }
            StringBuilder sb = new StringBuilder();
            if (isBold[0]) sb.append("<b>");
            for (int i = 0; i < isBold.length; i++) {
                sb.append(S.charAt(i));
                if (i == isBold.length - 1) {
                    if (isBold[i]) sb.append("</b>");
                    break;
                }
                if (isBold[i] && !isBold[i + 1]) sb.append("</b>");
                if (!isBold[i] && isBold[i + 1]) sb.append("<b>");
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}