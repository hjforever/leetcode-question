//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 541 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q567ZiFuChuanDePaiLie {
    public static void main(String[] args) {
        Solution solution = new Q567ZiFuChuanDePaiLie().new Solution();
        solution.checkInclusion("ab","ba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1 == null || s1.length() == 0 || s2 == null
                    || s2.length() == 0) return false;
            if (s1.length() > s2.length()) return false;
            if(s1.equals(s2)) return  true;
            Map<Character, Integer> s1Cnt = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                s1Cnt.put(s1.charAt(i), s1Cnt.getOrDefault(s1.charAt(i), 0) + 1);
            }
            int s1Len = s1.length();
            int left = 0;
            int right = 0;
            Map<Character, Integer> s2Cnt = new HashMap<>();
            while (right < s2.length()) {
                while (right - left + 1 <= s1Len) {
                    char ch = s2.charAt(right) ;
                    s2Cnt.put(ch, s2Cnt.getOrDefault(ch, 0) + 1);
                    right++;
                }
                if(check(s1Cnt,s2Cnt)){
                    return true ;
                }
                char ch = s2.charAt(left) ;
                int count = s2Cnt.get(ch) ;
                if(count<=1){
                    s2Cnt.remove(ch) ;
                }else {
                    s2Cnt.put(ch,count-1) ;
                }
                left++ ;
            }
            return  false ;
        }

        boolean check(Map<Character, Integer> s1, Map<Character, Integer> s2) {
            if (s1.keySet().size() != s2.keySet().size()) return false;
            for (char ch : s1.keySet()) {
                if (!s1.get(ch).equals(s2.getOrDefault(ch, 0))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}