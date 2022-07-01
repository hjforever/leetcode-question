//Given a string expression of numbers and operators, return all possible
//results from computing all the different possible ways to group numbers and operators.
// You may return the answer in any order. 
//
// The test cases are generated such that the output values fit in a 32-bit 
//integer and the number of different results does not exceed 10⁴. 
//
// 
// Example 1: 
//
// 
//Input: expression = "2-1-1"
//Output: [0,2]
//Explanation:
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// Example 2: 
//
// 
//Input: expression = "2*3-4*5"
//Output: [-34,-14,-10,-10,10]
//Explanation:
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= expression.length <= 20 
// expression consists of digits and the operator '+', '-', and '*'. 
// All the integer values in the input expression are in the range [0, 99]. 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 634 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q241DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new Q241DifferentWaysToAddParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> ans = new ArrayList<>();
            if (expression == null || expression.length() == 0) return ans;
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '+' || c == '*' || c == '-') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (Integer l : left) {
                        for (Integer r : right) {
                            ans.add(calc(l, r, c));
                        }
                    }
                }
            }
            //表示只有数字
            if (ans.size() == 0) {
                ans.add(Integer.parseInt(expression));
            }
            return ans;
        }

        public Integer calc(Integer left, Integer right, char op) {
            if (op == '+') {
                return left + right;
            } else if (op == '-') {
                return left - right;
            } else if (op == '*') {
                return left * right;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}