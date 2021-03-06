//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 1961 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Q70ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp , f(n) = f(n-1)+f(n-2)
        public int climbStairs(int n) {
            return climb(n);
        }

        int climb(int n) {
            if (n < 1) return 0;
            if (n == 1) {
                return 1;
            }
            if (n == 2)
                return 2;
            int prev = 1, curr = 2;
            for (int i = 3; i <= n; i++) {
                int sum = prev + curr;
                prev = curr;
                curr = sum;
            }
            return curr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}