//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
// Related Topics 栈 贪心 字符串 单调栈 👍 711 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q316QuChuZhongFuZiMu {
    public static void main(String[] args) {
        Solution solution = new Q316QuChuZhongFuZiMu().new Solution();
        solution.removeDuplicateLetters("bbcaac");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            //单调栈
            Stack<Character> stack = new Stack<>();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (stack.contains(ch)) {
                    //存在就跳过
                    continue;
                }
                //当后一个字符小于前一个字符，且前一个字符在后面还会出现并且不再栈中则出栈
                while (!stack.isEmpty() && ch < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                    stack.pop();
                }
                stack.push(ch);
            }
            for (int i = 0; i < stack.size(); i++) {
                res.append(stack.get(i));
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}