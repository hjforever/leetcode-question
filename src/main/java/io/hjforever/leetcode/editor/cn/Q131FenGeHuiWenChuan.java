//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1081 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q131FenGeHuiWenChuan {
    public static void main(String[] args) {
        Solution solution = new Q131FenGeHuiWenChuan().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] vist;
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();

        public List<List<String>> partition(String s) {
            // back trace
            int n = s.length();
            if (n == 1) {
                path.add(s);
                res.add(path);
                return res;
            }
            vist = new int[n][n];
            backTrace(s, 0);
            return res;
        }

        void backTrace(String s, int i) {
            if (i == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j < s.length(); j++) {
                if (isPalinerome(s, i, j)) {
                    path.addLast(s.substring(i, j + 1));
                    backTrace(s, j + 1);
                    //back
                    path.removeLast();
                }
            }
        }

        // is palinerome ,back up
        public boolean isPalinerome(String s, int i, int j) {
            if (vist[i][j] == 1) {
                return true;
            } else if (vist[i][j] == -1) {
                return false;
            }
            int left = i;
            int right = j;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    vist[i][j] = -1;
                    return false;
                }
                left++;
                right--;
            }
            vist[i][j] = 1;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}