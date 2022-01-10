//给定两个字符串 s 和 t，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 字符串 👍 413 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q205TongGouZiFuChuan {
    public static void main(String[] args) {
        Solution solution = new Q205TongGouZiFuChuan().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s == null && t == null) return true;
            if (s == null || t == null) return false;
            if (s.length() != t.length()) return false;
            if (s.equals(t)) return true;
            Map<Character, Character> sdict = new HashMap();
            Map<Character, Character> tdict = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char ss = s.charAt(i);
                char tt = t.charAt(i);
                if (sdict.containsKey(ss)) {
                    if (tt != sdict.get(ss)) {
                        return false;
                    }
                }
                if (tdict.containsKey(tt)) {
                    if (ss != tdict.get(tt)) {
                        return false;
                    }
                }
                sdict.put(ss, tt);
                tdict.put(tt, ss);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}