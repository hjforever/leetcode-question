//给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。
//
// 请你向 expression 中添加一对括号，使得在添加之后， expression 仍然是一个有效的数学表达式，并且计算后可以得到 最小 可能值。左括号
// 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。 
//
// 返回添加一对括号后形成的表达式 expression ，且满足 expression 计算得到 最小 可能值。如果存在多个答案都能产生相同结果，返回任意一
//个答案。 
//
// 生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 输入：expression = "247+38"
//输出："2(47+38)"
//解释：表达式计算得到 2 * (47 + 38) = 2 * 85 = 170 。
//注意 "2(4)7+38" 不是有效的结果，因为右括号必须添加在 '+' 的右侧。
//可以证明 170 是最小可能值。
// 
//
// 示例 2： 
//
// 输入：expression = "12+34"
//输出："1(2+3)4"
//解释：表达式计算得到 1 * (2 + 3) * 4 = 1 * 5 * 4 = 20 。
// 
//
// 示例 3： 
//
// 输入：expression = "999+999"
//输出："(999+999)"
//解释：表达式计算得到 999 + 999 = 1998 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= expression.length <= 10 
// expression 仅由数字 '1' 到 '9' 和 '+' 组成 
// expression 由数字开始和结束 
// expression 恰好仅含有一个 '+'. 
// expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围 
// 
// 👍 3 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q6038XiangBiaoDaShiTianJiaKuoHaoHouDeZuiXiaoJieGuo {
    public static void main(String[] args) {
        Solution solution = new Q6038XiangBiaoDaShiTianJiaKuoHaoHouDeZuiXiaoJieGuo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;


        // 暴力枚举搜索
        public String minimizeResult(String expression) {
            String[] s = expression.split("\\+");
            dfs(0, 0, s[0], s[1]);
            if (left == 0 && right == 0) {
                return "(" + expression + ")";
            } else if (left == 0 && right != 0) {
                return "(" + s[0] + "+" + s[1].substring(0, right) + ")" + s[1].substring(right);
            } else if (left != 0 && right == 0) {
                return s[0].substring(0, left) + "(" + s[0].substring(left) + "+" + s[1] + ")";
            } else {
                return s[0].substring(0, left) + "(" + s[0].substring(left) + "+" + s[1].substring(0, right) + ")" + s[1].substring(right);
            }
        }

        void dfs(int i, int j, String num1, String num2) {

            if (i == num1.length() || j == num2.length()) {
                return;
            }
            int cc = calc(i, j, num1, num2);
            if (cc < result) {
                result = cc;
                left = i;
                right = j;
            }
            //i++
            dfs(i + 1, j, num1, num2);
            //j--
            dfs(i, j + 1, num1, num2);
            //i++ , j--
            dfs(i + 1, j + 1, num1, num2);
        }

        public int calc(int i, int j, String num1, String num2) {
            String l1 = "1", l2 = "1", r1 = "1", r2 = "1";
            if (i == 0 && j == 0) {
                return Integer.parseInt(num1) + Integer.parseInt(num2);
            }
            if (i == 0 && j != 0) {
                l2 = num1;
                r1 = num2.substring(0, j);
                r2 = num2.substring(j);
            }
            if (i != 0 && j == 0) {
                l1 = num1.substring(0, i);
                l2 = num1.substring(i);
                r1 = num2;
            }
            if (i != 0 && j != 0) {
                //calc
                l1 = num1.substring(0, i);
                l2 = num1.substring(i);
                r1 = num2.substring(0, j);
                r2 = num2.substring(j);
            }
            int calc = Integer.parseInt(l1) * (Integer.parseInt(l2) + Integer.parseInt(r1)) * Integer.parseInt(r2);
            return calc;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}