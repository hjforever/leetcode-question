//A string s is called good if there are no two different characters in s that
//have the same frequency. 
//
// Given a string s, return the minimum number of characters you need to delete 
//to make s good. 
//
// The frequency of a character in a string is the number of times it appears 
//in the string. For example, in the string "aab", the frequency of 'a' is 2, while 
//the frequency of 'b' is 1. 
//
// 
// Example 1: 
//
// 
//Input: s = "aab"
//Output: 0
//Explanation: s is already good.
// 
//
// Example 2: 
//
// 
//Input: s = "aaabbbcc"
//Output: 2
//Explanation: You can delete two 'b's resulting in the good string "aaabcc".
//Another way it to delete one 'b' and one 'c' resulting in the good string 
//"aaabbc". 
//
// Example 3: 
//
// 
//Input: s = "ceabaacb"
//Output: 2
//Explanation: You can delete both 'c's resulting in the good string "eabaab".
//Note that we only care about characters that are still in the string at the 
//end (i.e. frequency of 0 is ignored).
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s contains only lowercase English letters. 
// 
// Related Topics 贪心 字符串 排序 👍 43 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1647MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        Solution solution = new Q1647MinimumDeletionsToMakeCharacterFrequenciesUnique().new Solution();
        solution.minDeletions("abcabc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDeletions(String s) {
            // sort,  greedy
            int ans = 0;
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
            }
            Arrays.sort(cnt);
            Set<Integer> exist = new HashSet();
            for (int i = 0; i < 26; i++) {
                int count = cnt[i];
                while (count > 0 && !exist.add(count)) {
                    count--;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}