//You are given a string s and an array of strings words of the same length.
//Return all starting indices of substring(s) in s that is a concatenation of each 
//word in words exactly once, in any order, and without any intervening characters. 
//
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "barfoothefoobarman", words = ["foo","bar"]
//Output: [0,9]
//Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" 
//respectively.
//The output order does not matter, returning [9,0] is fine too.
// 
//
// Example 2: 
//
// 
//Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//Output: []
// 
//
// Example 3: 
//
// 
//Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//Output: [6,9,12]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lower-case English letters. 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] consists of lower-case English letters. 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 713 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q30SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new Q30SubstringWithConcatenationOfAllWords().new Solution();
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //hash + sliding window
        //题目words中长度相同，大大的减小了难度，只要根据长度划分字符串，然后统计是否相同就ok
        public List<Integer> findSubstring(String s, String[] words) {

            List<Integer> ans = new ArrayList<>();
            int n = s.length();
            int m = words.length;
            int wordLength = words[0].length();

            if (n < wordLength * m) return ans;

            Map<String, Integer> wcnt = new HashMap<>();
            for (String word : words) {
                wcnt.put(word, wcnt.getOrDefault(word, 0) + 1);
            }
            //获取 m*wordLength 长度的子串，并统计对应word length长度的字符串统计
            for (int i = 0; i + (m * wordLength) - 1 < n; i++) {
                Map<String, Integer> scnt = new HashMap<>();
                boolean sub = true;
                for (int j = 0; j < m; j++) {
                    String w = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                    if (!wcnt.containsKey(w)) {
                        sub = false;
                        break;
                    }
                    scnt.put(w, scnt.getOrDefault(w, 0) + 1);
                }
                if (!sub) continue;
                sub = check(scnt, wcnt);
                if (sub) {
                    ans.add(i);
                }
            }
            return ans;
        }

        boolean check(Map<String, Integer> scnt, Map<String, Integer> wcnt) {
            if (scnt.keySet().size() != wcnt.keySet().size()) return false;
            for (String key : wcnt.keySet()) {
                if (!Objects.equals(scnt.get(key), wcnt.get(key))) return false;
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}