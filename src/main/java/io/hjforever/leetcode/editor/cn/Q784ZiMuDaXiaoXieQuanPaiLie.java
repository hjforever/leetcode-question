//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 👍 321 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q784ZiMuDaXiaoXieQuanPaiLie {
    public static void main(String[] args) {
        Solution solution = new Q784ZiMuDaXiaoXieQuanPaiLie().new Solution();
        solution.letterCasePermutation("a1b2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        Set<String> res = new HashSet();

        public List<String> letterCasePermutation(String s) {
            char[] ch = s.toCharArray();
            dfs(ch, "", 0);
            return new ArrayList(res);
        }

        void dfs(char[] chars, String s, int start) {
            if (chars.length == s.length()) {
                res.add(s);
                return;
            }
            char ch = chars[start];
            if (Character.isLetter(ch)) {
                //改变大小写
                dfs(chars, s + Character.toUpperCase(ch), start + 1);
                dfs(chars, s + Character.toLowerCase(ch), start + 1);
            } else {
                dfs(chars, s + ch, start + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}