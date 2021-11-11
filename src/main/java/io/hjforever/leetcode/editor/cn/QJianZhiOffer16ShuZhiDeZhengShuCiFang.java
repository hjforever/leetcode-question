//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 216 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer16ShuZhiDeZhengShuCiFang {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer16ShuZhiDeZhengShuCiFang().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //主要犯了 n溢出的错误，当n为最小值是 -n会溢出故先转成long
        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            if (n == 0) {
                return 1;
            }
            long abs = n;
            abs = abs < 0 ? -abs : abs;

            double result = 1.0d;
            double t = x;
            while (abs > 0) {
                if (abs % 2 == 1) {
                    result *= t;
                }
                t *= t;
                abs /= 2;
            }
            if (n >= 0) {
                return result;
            } else {
                return 1 / result;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}