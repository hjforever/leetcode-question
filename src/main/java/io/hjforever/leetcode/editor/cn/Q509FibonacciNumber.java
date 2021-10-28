//斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给你 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 340 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q509FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new Q509FibonacciNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] backUp;

        //此处可以用备忘录模式或者尾递归优化
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 1;
            }
            backUp = new int[n + 1];
            Arrays.fill(backUp, -1);
            backUp[0] = 0;
            backUp[1] = 1;
            backUp[2] = 1;
            return fibNum(n);
        }

        int fibNum(int n) {
            if (backUp[n] >= 0) {
                return backUp[n];
            } else {
                int fib = fibNum(n - 1) + fibNum(n - 2);
                backUp[n] = fib;
                return fib;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}