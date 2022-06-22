//You are given two string arrays words1 and words2.
//
// A string b is a subset of string a if every letter in b occurs in a 
//including multiplicity. 
//
// 
// For example, "wrr" is a subset of "warrior" but is not a subset of "world". 
// 
//
// A string a from words1 is universal if for every string b in words2, b is a 
//subset of a. 
//
// Return an array of all the universal strings in words1. You may return the 
//answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = [
//"e","o"]
//Output: ["facebook","google","leetcode"]
// 
//
// Example 2: 
//
// 
//Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = [
//"l","e"]
//Output: ["apple","google","leetcode"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= words1.length, words2.length <= 10⁴ 
// 1 <= words1[i].length, words2[i].length <= 10 
// words1[i] and words2[i] consist only of lowercase English letters. 
// All the strings of words1 are unique. 
// 
// Related Topics 数组 哈希表 字符串 👍 78 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q916WordSubsets {
    public static void main(String[] args) {
        Solution solution = new Q916WordSubsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordSubsets(String[] words1, String[] words2) {
            // hash,count
            int[] cnt2 = new int[26];
            for (String w : words2) {
                int[] ct = cnt(w);
                for (int i = 0; i < 26; i++) {
                    if (ct[i] > cnt2[i]) {
                        cnt2[i] = ct[i];
                    }
                }
            }
            List<String> ans = new ArrayList<>();
            for (String w : words1) {
                int[] ct = cnt(w);
                if (subSet(ct, cnt2)) {
                    ans.add(w);
                }
            }
            return ans;
        }

        int[] cnt(String w) {
            char[] ww = w.toCharArray();
            int[] ct = new int[26];
            for (int i = 0; i < ww.length; i++) {
                ct[ww[i] - 'a']++;
            }
            return ct;
        }

        boolean subSet(int[] cnt1, int[] cnt2) {
            for (int j = 0; j < 26; j++) {
                if (cnt2[j] > 0 && (cnt1[j] < cnt2[j])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}