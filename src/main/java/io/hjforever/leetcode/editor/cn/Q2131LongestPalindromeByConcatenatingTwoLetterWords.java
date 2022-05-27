//You are given an array of strings words. Each element of words consists of
//two lowercase English letters. 
//
// Create the longest possible palindrome by selecting some elements from words 
//and concatenating them in any order. Each element can be selected at most once. 
//
//
// Return the length of the longest palindrome that you can create. If it is 
//impossible to create any palindrome, return 0. 
//
// A palindrome is a string that reads the same forward and backward. 
//
// 
// Example 1: 
//
// 
//Input: words = ["lc","cl","gg"]
//Output: 6
//Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of 
//length 6.
//Note that "clgglc" is another longest palindrome that can be created.
// 
//
// Example 2: 
//
// 
//Input: words = ["ab","ty","yt","lc","cl","ab"]
//Output: 8
//Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt",
// of length 8.
//Note that "lcyttycl" is another longest palindrome that can be created.
// 
//
// Example 3: 
//
// 
//Input: words = ["cc","ll","xx"]
//Output: 2
//Explanation: One longest palindrome is "cc", of length 2.
//Note that "ll" is another longest palindrome that can be created, and so is 
//"xx".
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁵ 
// words[i].length == 2 
// words[i] consists of lowercase English letters. 
// 
// Related Topics 贪心 数组 哈希表 字符串 计数 👍 11 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2131LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        Solution solution = new Q2131LongestPalindromeByConcatenatingTwoLetterWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String[] words) {
            // map cnt
            Map<String, Integer> cnt = new HashMap<>();
            for (String str : words) {
                cnt.put(str, cnt.getOrDefault(str, 0) + 1);
            }
            int ans = 0;
            Set<String> set = new HashSet<>();
            boolean hasMid = false;
            for (String key : words) {
                if (set.contains(key)) continue;
                char f1 = key.charAt(0);
                char f2 = key.charAt(1);
                if (f1 == f2) {
                    //1. aa
                    if (cnt.get(key) % 2 == 1) {
                        hasMid = true;
                    }
                    ans += (cnt.get(key) / 2) * 4;
                    set.add(key);
                } else {
                    //2. ab -> ba
                    String pstr = "" + f2 + f1;
                    int f1cnt = cnt.getOrDefault(key, 0);
                    int f2cnt = cnt.getOrDefault(pstr, 0);
                    int min = Math.min(f1cnt, f2cnt);
                    ans += 4 * min;
                    set.add(pstr);
                    set.add(key);
                }
            }
            return hasMid ? ans + 2 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}