//Given a string s and an integer k, return true if you can use all the
//characters in s to construct k palindrome strings or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "annabelle", k = 2
//Output: true
//Explanation: You can construct two palindromes using all characters in s.
//Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + 
//"b"
// 
//
// Example 2: 
//
// 
//Input: s = "leetcode", k = 3
//Output: false
//Explanation: It is impossible to construct 3 palindromes using all the 
//characters of s.
// 
//
// Example 3: 
//
// 
//Input: s = "true", k = 4
//Output: true
//Explanation: The only possible solution is to put each character in a 
//separate string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 1 <= k <= 10⁵ 
// 
// Related Topics 贪心 哈希表 字符串 计数 👍 41 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1400ConstructKPalindromeStrings {
    public static void main(String[] args) {
        Solution solution = new Q1400ConstructKPalindromeStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String s, int k) {
            //奇数次的字母, 要组成回文串, 必须单独形成
            //因此奇数次的个数要小于k
            if (s.length() < k) return false;
            int[] cnt = new int[26];
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                cnt[ch[i] - 'a']++;
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                if ((cnt[i] & 1) == 1) {
                    ans++;
                }
            }
            return ans <= k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}