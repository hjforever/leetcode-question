//You are given a string s and an integer k. You can choose any character of
//the string and change it to any other uppercase English character. You can perform 
//this operation at most k times. 
//
// Return the length of the longest substring containing the same letter you 
//can get after performing the above operations. 
//
// 
// Example 1: 
//
// 
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
// 
//
// Example 2: 
//
// 
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only uppercase English letters. 
// 0 <= k <= s.length 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 625 👎 0


package io.hjforever.leetcode.editor.cn;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.Arrays;

public class Q424LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new Q424LongestRepeatingCharacterReplacement().new Solution();
        System.out.println(solution.characterReplacement("AABABBA", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            //sliding window
            //当最大出现k+1个字符时则可以满足条件
            //先枚举看操作成哪一个字符
            int n = s.length();
            char[] ch = s.toCharArray();
            int ans = 0;
            int[] cnt = new int[26];
            int l = 0, r = 0;
            int max = 0;
            while (r < n) {
                char c = ch[r];
                cnt[c - 'A']++;
                max = Math.max(cnt[c - 'A'], max);
                while (r - l + 1 - max > k) {
                    cnt[ch[l++] - 'A']--;
                }
                ans = Math.max(ans, r - l + 1);
                r++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}