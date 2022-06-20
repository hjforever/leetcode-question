//A string s is nice if, for every letter of the alphabet that s contains, it
//appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' 
//and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' 
//appears, but 'B' does not. 
//
// Given a string s, return the longest substring of s that is nice. If there 
//are multiple, return the substring of the earliest occurrence. If there are none, 
//return an empty string. 
//
// 
// Example 1: 
//
// 
//Input: s = "YazaAay"
//Output: "aAa"
//Explanation: "aAa" is a nice string because 'A/a' is the only letter of the 
//alphabet in s, and both 'A' and 'a' appear.
//"aAa" is the longest nice substring.
// 
//
// Example 2: 
//
// 
//Input: s = "Bb"
//Output: "Bb"
//Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole 
//string is a substring.
// 
//
// Example 3: 
//
// 
//Input: s = "c"
//Output: ""
//Explanation: There are no nice substrings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of uppercase and lowercase English letters. 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 👍 174 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q1763LongestNiceSubstring {
    public static void main(String[] args) {
        Solution solution = new Q1763LongestNiceSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestNiceSubstring(String s) {
            //1.暴力循环
//            int max = 0;
//            String ans = "";
//            int n = s.length();
//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    String str = s.substring(i, j + 1);
//                    if (check(str)) {
//                        if (str.length() > max) {
//                            ans = str;
//                            max = str.length();
//                        }
//                    }
//                }
//            }
//            return ans;
            //2.位运算
            int ans = 0;
            int idx = -1;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                int low = 0;
                int up = 0;
                for (int j = i; j < n; j++) {
                    char ch = s.charAt(j);
                    if (Character.isUpperCase(ch)) {
                        up |= (1 << (ch - 'A'));
                    } else {
                        low |= (1 << (ch - 'a'));
                    }
                    if (low == up && (j - i + 1) > ans) {
                        ans = (j - i + 1);
                        idx = i;
                    }
                }
            }
            return ans == 0 ? "" : s.substring(idx, idx + ans);
        }

        boolean check(String s) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isUpperCase(ch) && !set.contains(Character.toLowerCase(ch))) {
                    return false;
                } else if (Character.isLowerCase(ch) && !set.contains(Character.toUpperCase(ch))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}