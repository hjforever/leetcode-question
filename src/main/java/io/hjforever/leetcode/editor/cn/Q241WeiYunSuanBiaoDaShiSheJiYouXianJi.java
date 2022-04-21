//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 549 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q241WeiYunSuanBiaoDaShiSheJiYouXianJi {
    public static void main(String[] args) {
        Solution solution = new Q241WeiYunSuanBiaoDaShiSheJiYouXianJi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, List<Integer>> backUp = new HashMap<>();

        public List<Integer> diffWaysToCompute(String expression) {
            //此处有重复计算子问题，可以增加backup
            if (backUp.containsKey(expression)) {
                return backUp.get(expression);
            }
            List<Integer> res = new ArrayList<>();
            //recursion
            //分治和递归
            if (expression == null || expression.length() == 0) {
                return res;
            }
            //分治子问题
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch == '+' || ch == '-' || ch == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (Integer l : left) {
                        for (Integer r : right) {
                            res.add(calc(l, r, ch));
                        }
                    }
                }
            }
            //此处需要判断是否是纯数字
            if (res.size() == 0) {
                res.add(Integer.valueOf(expression));
            }
            backUp.put(expression, res);
            return res;
        }

        public Integer calc(Integer left, Integer right, char operator) {
            if (operator == '+') {
                return left + right;
            } else if (operator == '-') {
                return left - right;
            } else if (operator == '*') {
                return left * right;
            }
            return -1;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}