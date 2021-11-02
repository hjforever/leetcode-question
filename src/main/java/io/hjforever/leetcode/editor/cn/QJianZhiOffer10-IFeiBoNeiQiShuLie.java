//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 252 👎 0


package io.hjforever.leetcode.editor.cn;

class QJianZhiOffer10IFeiBoNeiQiShuLie {
    public static void main(String[] args) {
        // Solution solution = new QJianZhiOffer10-IFeiBoNeiQiShuLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            //递归和循环
            //递归效率不高，需要用备忘录模式
            long fibN1 = 1;
            long fibN2 = 0;
            long fib = 0;
            for (int k = 2; k <= n; k++) {
                //需要在过程中取余，否则会溢出
                fib = (fibN1 + fibN2) % 1000000007;
                fibN2 = fibN1;
                fibN1 = fib;
            }
            return (int) fib;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}