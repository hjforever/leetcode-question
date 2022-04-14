//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 871 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q204JiShuZhiShu {
    public static void main(String[] args) {
        Solution solution = new Q204JiShuZhiShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            // eratosthenes
            if (n == 0) return 0;
            if (n == 1) return 0;
            int[] f = new int[n + 10];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (f[i] == 1) continue;
                count++;
                for (int j = i; j <= n / i; j++) f[i * j] = 1;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}