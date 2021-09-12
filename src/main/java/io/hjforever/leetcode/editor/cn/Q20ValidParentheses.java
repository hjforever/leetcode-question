//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2638 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Stack;

public class Q20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q20ValidParentheses().new Solution();
        System.out.println(solution.isValid("{}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 典型的栈问题，当遇到 前缀则入栈，遇到后缀则出栈,当栈为空则表示有效
         */
        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    //入栈
                    stack.push(c);
                } else {
                    //出栈
                    //当栈为空但是需要出栈则不匹配
                    if (stack.isEmpty()) {
                        return false;
                    }
                    //出栈匹配判断
                    Character val = stack.pop();
                    if (c == ')') {
                        if (val != '(') {
                            return false;
                        }
                    }
                    if (c == ']') {
                        if (val != '[') {
                            return false;
                        }
                    }
                    if (c == '}') {
                        if (val != '{') {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}