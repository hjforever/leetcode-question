//Given an array of strings strs, return the length of the longest uncommon
//subsequence between them. If the longest uncommon subsequence does not exist, 
//return -1. 
//
// An uncommon subsequence between an array of strings is a string that is a 
//subsequence of one string but not the others. 
//
// A subsequence of a string s is a string that can be obtained after deleting 
//any number of characters from s. 
//
// 
// For example, "abc" is a subsequence of "aebdc" because you can delete the 
//underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" 
//include "aebdc", "aeb", and "" (empty string). 
// 
//
// 
// Example 1: 
// Input: strs = ["aba","cdc","eae"]
//Output: 3
// Example 2: 
// Input: strs = ["aaa","aaa","aa"]
//Output: -1
// 
// 
// Constraints: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] consists of lowercase English letters. 
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 👍 102 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q522LongestUncommonSubsequenceII {
    public static void main(String[] args) {
        Solution solution = new Q522LongestUncommonSubsequenceII().new Solution();
        solution.findLUSlength(new String[]{"aaa", "aaa", "aa"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set = new HashSet<>();
        Set<String> removeSet = new HashSet<>();

        public int findLUSlength(String[] strs) {
            int n = strs.length;
            for (int i = 0; i < n; i++) {
                dfs(strs[i], 0, "");
            }
            int ans = -1;
            for (String s : set) {
                ans = Math.max(ans, s.length());
            }
            return ans;
        }

        void dfs(String s, int idx, String path) {
            int n = s.length();
            if (idx == n) {
                if (removeSet.contains(path)) {
                    return;
                }
                if (set.contains(path)) {
                    set.remove(path);
                    removeSet.add(path);
                    return;
                }
                set.add(path);
                return;
            }
            dfs(s, idx + 1, path);
            dfs(s, idx + 1, path + s.charAt(idx));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}