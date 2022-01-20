//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 👍 1002 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.LinkedList;

public class Q394ZiFuChuanJieMa {
    public static void main(String[] args) {
        Solution solution = new Q394ZiFuChuanJieMa().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            LinkedList<Integer> stackMulti = new LinkedList<>();
            LinkedList<String> stackRes = new LinkedList<>();

            for (char ch : s.toCharArray()) {
                if (ch == '[') {
                    stackMulti.addLast(multi);
                    stackRes.addLast(res.toString());
                    multi = 0;
                    res = new StringBuilder();
                } else if (ch == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int multiNum = stackMulti.removeLast();
                    for (int i = 0; i < multiNum; i++) {
                        tmp.append(res);
                    }
                    res = new StringBuilder(stackRes.removeLast() + tmp);
                } else if (Character.isDigit(ch)) {
                    multi = multi * 10 + ch - '0';
                } else {
                    res.append(ch);
                }
            }
            return res.toString();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}