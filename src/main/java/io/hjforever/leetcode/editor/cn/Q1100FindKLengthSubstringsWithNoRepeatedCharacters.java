//Given a string s and an integer k, return the number of substrings in s of
//length k with no repeated characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "havefunonleetcode", k = 5
//Output: 6
//Explanation: There are 6 substrings they are: 'havef','avefu','vefun','efuno',
//'etcod','tcode'.
// 
//
// Example 2: 
//
// 
//Input: s = "home", k = 5
//Output: 0
//Explanation: Notice k can be larger than the length of s. In this case, it is 
//not possible to find any substring.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 1 <= k <= 10⁴ 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 39 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q1100FindKLengthSubstringsWithNoRepeatedCharacters {
    public static void main(String[] args) {
        Solution solution = new Q1100FindKLengthSubstringsWithNoRepeatedCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numKLenSubstrNoRepeats(String s, int k) {
            //sliding window
            int n = s.length();
            if (k > n) return 0;
            //sliding window
            Set<Character> set = new HashSet<>();
            int l = 0, r = 0;
            char[] ch = s.toCharArray();
            int ans = 0;
            while (r < n) {
                char c = ch[r];
                while (set.contains(c)) {
                    set.remove(ch[l++]);
                }
                set.add(c);
                if (r - l + 1 >= k) {
                    ans++;
                }
                r++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}