//Given a string s and an integer k, return the length of the longest substring
//of s such that the frequency of each character in this substring is greater 
//than or equal to k. 
//
// 
// Example 1: 
//
// 
//Input: s = "aaabb", k = 3
//Output: 3
//Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
// 
//
// Example 2: 
//
// 
//Input: s = "ababbc", k = 2
//Output: 5
//Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 
//'b' is repeated 3 times.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of only lowercase English letters. 
// 1 <= k <= 10⁵ 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 695 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class Q395LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Q395LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //本题的一个重要点在于只有确定了字符的数量后，才能用滑动窗口
        public int longestSubstring(String s, int k) {
            int n = s.length();
            char[] ch = s.toCharArray();
            int[] cnt = new int[26];
            int ans = 0;
            //枚举看最多有多少个字符出现
            for (int i = 1; i <= 26; i++) {
                // sliding window
                Arrays.fill(cnt, 0);
                int max = 0, l = 0, r = 0, count = 0;
                while (r < n) {
                    char c = ch[r];
                    int idx = c - 'a';
                    if (cnt[idx]++ == 0) count++;
                    //达到k个的字符数量
                    if (cnt[idx] == k) max++;
                    //超过i个字符，需要缩小左窗口
                    while (count > i) {
                        char lch = ch[l++];
                        cnt[lch - 'a']--;
                        if (cnt[lch - 'a'] == 0) {
                            count--;
                        }
                        if (cnt[lch - 'a'] == k - 1) max--;
                    }
                    if (count == max) {
                        ans = Math.max(ans, r - l + 1);
                    }
                    r++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}