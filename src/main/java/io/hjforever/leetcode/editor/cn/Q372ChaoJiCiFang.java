//你的任务是计算 aᵇ 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
//
// 
//
// 示例 1： 
//
// 
//输入：a = 2, b = [3]
//输出：8
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = [1,0]
//输出：1024
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = [4,3,3,8,5,2]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：a = 2147483647, b = [2,0,0]
//输出：1198
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 2³¹ - 1 
// 1 <= b.length <= 2000 
// 0 <= b[i] <= 9 
// b 不含前导 0 
// 
// Related Topics 数学 分治 👍 184 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q372ChaoJiCiFang {
    public static void main(String[] args) {
        Solution solution = new Q372ChaoJiCiFang().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        static final int MOD = 1337;

        public int superPow(int a, int[] b) {
            // 倒序遍历
            int res = 1;
            for (int i = b.length - 1; i >= 0; i--) {
                res = (res * fastPow(a, b[i], MOD)) % MOD;
                a = fastPow(a, 10, MOD);
            }
            return res;
        }

        //快速幂
        public int fastPow(long a, int b, int mod) {
            long res = 1;
            while (b != 0) {
                if (b % 2 != 0) {
                    res = (res * a) % mod;
                }
                a = (a * a) % mod;
                b = b / 2;
            }
            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}