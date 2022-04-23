//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零
// 
// Related Topics 栈 贪心 字符串 单调栈 👍 708 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Stack;

public class Q402YiDiaoKWeiShuZi {
    public static void main(String[] args) {
        Solution solution = new Q402YiDiaoKWeiShuZi().new Solution();
        String s = solution.removeKdigits("10200", 1);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //单调栈
        public String removeKdigits(String num, int k) {
            //从左到右，找第一个比后面大的字符，删除
            //单调栈
            int n = num.length();
            if (k >= n) return "0";
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < num.length(); i++) {
                int cur = num.charAt(i) - '0';
                while (k > 0 && !stack.isEmpty() && cur < stack.peek()) {
                    k--;
                    stack.pop();
                }
                stack.push(cur);
            }
            //当字符都为递增时，则需要从后面删掉k个数
            while (k > 0) {
                k--;
                stack.pop();
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) {
                res.append(stack.get(i));
            }
            //删除前导0
            while (res.length() > 0 && res.charAt(0) == '0') {
                res.delete(0, 1);
            }
            if (res.length() == 0) {
                return "0";
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}