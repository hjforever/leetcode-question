//Given a balanced parentheses string s, return the score of the string.
//
// The score of a balanced parentheses string is based on the following rule: 
//
// 
// "()" has score 1. 
// AB has score A + B, where A and B are balanced parentheses strings. 
// (A) has score 2 * A, where A is a balanced parentheses string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: s = "(())"
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: s = "()()"
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 2 <= s.length <= 50 
// s consists of only '(' and ')'. 
// s is a balanced parentheses string. 
// 
// Related Topics 栈 字符串 👍 293 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Stack;

public class Q856ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new Q856ScoreOfParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(0);
                } else {
                    int v = stack.pop();
                    int w = stack.pop();
                    stack.push(w + Math.max(2 * v, 1));
                }
            }
            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}