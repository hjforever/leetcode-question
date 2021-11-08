//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2136 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q22KuoHaoShengCheng {
    public static void main(String[] args) {
        Solution solution = new Q22KuoHaoShengCheng().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> res = new HashSet<>();


        //回溯然后单个校验，效率太低，需要剪枝
        public List<String> generateParenthesis(int n) {
            //return generateParenthesisByBack(n);
            //List<String> list = new ArrayList<>();
            dfs(0, 0, n, "");
            return new ArrayList<>(res);
        }


        //dfs
        void dfs(int open, int close, int n, String path) {
            if (open > n || close > n || open < close) {
                //剪枝  ( 的数量要确保大或者等于 ) 的数量
                return;
            }
            if (open == close && open == n) {
                res.add(path);
                return;
            }
            dfs(open + 1, close, n, path + "(");
            dfs(open, close + 1, n, path + ")");
        }


        /**
         * 回溯加校验
         *
         * @param n
         * @return
         */
        public List<String> generateParenthesisByBack(int n) {
            //排列组合
            backTrack(n, n, n, new LinkedList<>());
            List<String> list = new ArrayList<>();
            for (String s : res) {
                if (validate(s)) {
                    list.add(s);
                }
            }
            return list;
        }

        //格式验证
        boolean validate(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }

        //回溯函数
        void backTrack(int n, int k1, int k2, LinkedList<Character> track) {
            //1.触发条件
            if (track.size() == 2 * n) {
                StringBuilder builder = new StringBuilder();
                for (Character ch : track) {
                    builder.append(ch);
                }
                res.add(builder.toString());
                return;
            }

            if (track.isEmpty()) {
                track.add('(');
                backTrack(n, k1 - 1, k2, track);
                track.removeLast();
                return;
            }

            if (k1 > 0 && k2 > 0) {
                track.add('(');
                backTrack(n, k1 - 1, k2, track);
                track.removeLast();
                track.add(')');
                backTrack(n, k1, k2 - 1, track);
                track.removeLast();
                return;
            }
            if (k1 > 0) {
                track.add('(');
                backTrack(n, k1 - 1, k2, track);
                track.removeLast();
                return;
            }
            if (k2 > 0) {
                track.add(')');
                backTrack(n, k1, k2 - 1, track);
                track.removeLast();
                return;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}