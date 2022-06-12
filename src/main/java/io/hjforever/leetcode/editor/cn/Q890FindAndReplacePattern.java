//Given a list of strings words and a string pattern, return a list of words[i]
//that match pattern. You may return the answer in any order. 
//
// A word matches the pattern if there exists a permutation of letters p so 
//that after replacing every letter x in the pattern with p(x), we get the desired 
//word. 
//
// Recall that a permutation of letters is a bijection from letters to letters: 
//every letter maps to another letter, and no two letters map to the same letter. 
//
//
// 
// Example 1: 
//
// 
//Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//Output: ["mee","aqq"]
//Explanation: "mee" matches the pattern because there is a permutation {a -> m,
// b -> e, ...}. 
//"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a 
//permutation, since a and b map to the same letter.
// 
//
// Example 2: 
//
// 
//Input: words = ["a","b","c"], pattern = "a"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 20 
// 1 <= words.length <= 50 
// words[i].length == pattern.length 
// pattern and words[i] are lowercase English letters. 
// 
// Related Topics 数组 哈希表 字符串 👍 144 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q890FindAndReplacePattern {
    public static void main(String[] args) {
        Solution solution = new Q890FindAndReplacePattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            // map , monitor
            int n = words.length;
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (match(words[i], pattern)) {
                    ans.add(words[i]);
                }
            }
            return ans;
        }

        public boolean match(String word, String pattern) {
            int n = word.length();
            int[] map = new int[26];
            int[] vis = new int[26];
            Arrays.fill(map, -1);
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) {
                int wIdx = word.charAt(i) - 'a';
                int pIdx = pattern.charAt(i) - 'a';
                if (map[wIdx] == -1 && vis[pIdx] == 0) {
                    map[wIdx] = pIdx;
                    vis[pIdx] = 1;
                } else if (map[wIdx] != pIdx) {
                    ok = false;
                }
            }
            return ok;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}