//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 👍 528 👎 0


package io.hjforever.leetcode.editor.cn;

import sun.font.CreatedFontTracker;

import java.util.*;

public class Q301RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q301RemoveInvalidParentheses().new Solution();
        System.out.println(solution.removeInvalidParentheses("()())()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> resutl = new ArrayList<>();
            Set<String> currSet = new HashSet<>();
            currSet.add(s);
            while (true) {
                for (String str : currSet) {
                    if (invalidateParten(str)) {
                        resutl.add(str);
                    }
                }
                //当找到最小则返回因为字符串是从0到length删除，则最早发现，则为最小删除
                if (resutl.size() > 0) {
                    return resutl;
                }
                //保存删除n个元素的字符串列表，需要去重
                Set<String> nextSet = new HashSet<>();
                //从0到length删除，当符合条件则返回
                for (String str : currSet) {
                    for (int i = 0; i < str.length(); i++) {
                        //剪枝，当前面为相同的字符串时去最后一个
                        if (i > 0 && str.charAt(i) == str.charAt(i-1)) {
                            continue;
                        }
                        //当为括号则进行删除
                        //此处还可以进行剪枝但是过于复杂
                        if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                            nextSet.add(str.substring(0, i) + str.substring(i + 1));
                        }
                    }
                }
                //将当前set设置为下一个set集合继续搜索
                currSet = nextSet;
            }
        }


        //检验是否合法
        public boolean invalidateParten(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            //栈
            Stack<Character> statck = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '(' && c != ')') {
                    continue;
                }
                if (statck.isEmpty() && c == ')') {
                    return false;
                }
                if (c == '(') {
                    statck.push(c);
                } else if (c == ')') {
                    char pre = statck.peek();
                    if (pre == '(') {
                        statck.pop();
                    }
                }
            }
            if (statck.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}