//Given a string s of '(' , ')' and lowercase English characters.
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in 
//any positions ) so that the resulting parentheses string is valid and return any 
//valid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either'(' , ')', or lowercase English letter. 
// 
// Related Topics 栈 字符串 👍 186 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1249MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q1249MinimumRemoveToMakeValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minRemoveToMakeValid(String s) {

            //stack , 和检验是否是有效的()号题目一直

            Set<Integer> deleteSet = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        deleteSet.add(i);
                    } else {
                        stack.pop();
                    }
                }
            }

            while (!stack.isEmpty()) {
                deleteSet.add(stack.pop());
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!deleteSet.contains(i)) {
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}