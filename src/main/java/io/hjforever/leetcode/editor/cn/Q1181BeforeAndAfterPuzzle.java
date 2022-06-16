//Given a list of phrases, generate a list of Before and After puzzles.
//
// A phrase is a string that consists of lowercase English letters and spaces 
//only. No space appears in the start or the end of a phrase. There are no 
//consecutive spaces in a phrase. 
//
// Before and After puzzles are phrases that are formed by merging two phrases 
//where the last word of the first phrase is the same as the first word of the 
//second phrase. 
//
// Return the Before and After puzzles that can be formed by every two phrases 
//phrases[i] and phrases[j] where i != j. Note that the order of matching two 
//phrases matters, we want to consider both orders. 
//
// You should return a list of distinct strings sorted lexicographically. 
//
// 
// Example 1: 
//
// 
//Input: phrases = ["writing code","code rocks"]
//Output: ["writing code rocks"]
// 
//
// Example 2: 
//
// 
//Input: phrases = ["mission statement",
//                  "a quick bite to eat",
//                  "a chip off the old block",
//                  "chocolate bar",
//                  "mission impossible",
//                  "a man on a mission",
//                  "block party",
//                  "eat my words",
//                  "bar of soap"]
//Output: ["a chip off the old block party",
//         "a man on a mission impossible",
//         "a man on a mission statement",
//         "a quick bite to eat my words",
//         "chocolate bar of soap"]
// 
//
// Example 3: 
//
// 
//Input: phrases = ["a","b","a"]
//Output: ["a"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= phrases.length <= 100 
// 1 <= phrases[i].length <= 100 
// 
// Related Topics 数组 哈希表 字符串 排序 👍 12 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1181BeforeAndAfterPuzzle {
    public static void main(String[] args) {
        Solution solution = new Q1181BeforeAndAfterPuzzle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> beforeAndAfterPuzzles(String[] phrases) {
            //map
            Map<String, List<Integer>> head = new HashMap<>();
            Map<String, List<Integer>> tail = new HashMap<>();
            Set<String> ans = new HashSet<>();
            for (int i = 0; i < phrases.length; i++) {
                String[] words = phrases[i].split(" ");
                List<Integer> h = head.getOrDefault(words[0], new ArrayList<>());
                h.add(i);
                head.put(words[0], h);
                List<Integer> t = tail.getOrDefault(words[words.length - 1], new ArrayList<>());
                t.add(i);
                tail.put(words[words.length - 1], t);
            }
            for (String key : tail.keySet()) {
                List<Integer> tlist = tail.get(key);
                if (head.containsKey(key)) {
                    List<Integer> hlist = head.get(key);
                    for (int t : tlist) {
                        for (int h : hlist) {
                            if (t != h) {
                                ans.add(phrases[t] + phrases[h].substring(key.length()));
                            }
                        }
                    }
                }
            }
            List<String> res = new ArrayList<>(ans);
            Collections.sort(res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}