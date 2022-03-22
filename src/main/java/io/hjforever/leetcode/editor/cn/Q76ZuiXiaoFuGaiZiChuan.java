//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1731 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q76ZuiXiaoFuGaiZiChuan {
    public static void main(String[] args) {
        Solution solution = new Q76ZuiXiaoFuGaiZiChuan().new Solution();
        solution.minWindow("ADOBECODEBANC", "ABC");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //滑动窗口
            if (s.length() < t.length()) return "";
            Map<Character, Integer> tMap = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            }
            Map<Character, Integer> sMap = new HashMap<>();
            int left = 0;
            int right = 0;
            int n = s.length();

            int minLen = Integer.MAX_VALUE;
            int leftRes = -1;
            int rightRes = -1;
            while (true) {
                //可以用是否包含来剪枝
                if (right < n) {
                    char c = s.charAt(right);
                    if (tMap.containsKey(c)) {
                        sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                    }
                    right++;
                }
                while (all(sMap, tMap)) {
                    int len = right - left;
                    if (len < minLen) {
                        leftRes = left;
                        rightRes = right;
                        minLen = len;
                    }
                    char leftChar = s.charAt(left);
                    if (tMap.containsKey(leftChar)) {
                        int count = sMap.get(leftChar);
                        if (count <= 1) {
                            sMap.remove(leftChar);
                        } else {
                            sMap.put(leftChar, count - 1);
                        }
                    }
                    left++;
                }
                if (right >= n && !all(sMap, tMap)) {
                    break;
                }
            }

            if (leftRes == -1) {
                return "";
            } else {
                return s.substring(leftRes, rightRes);
            }

        }

        //判断是否相同
        boolean all(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
            for (Character c : tMap.keySet()) {
                if (sMap.containsKey(c) && sMap.get(c) >= tMap.get(c)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}