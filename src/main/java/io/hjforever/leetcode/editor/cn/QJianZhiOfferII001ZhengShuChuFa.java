//给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
//
// 
//
// 注意： 
//
// 
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 2³¹−1]。本题中，如果除法结果溢出，则返回 231 − 1 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 15, b = 2
//输出：7
//解释：15/2 = truncate(7.5) = 7
// 
//
// 示例 2： 
//
// 
//输入：a = 7, b = -3
//输出：-2
//解释：7/-3 = truncate(-2.33333..) = -2 
//
// 示例 3： 
//
// 
//输入：a = 0, b = 1
//输出：0 
//
// 示例 4： 
//
// 
//输入：a = 1, b = 1
//输出：1 
//
// 
//
// 提示: 
//
// 
// -2³¹ <= a, b <= 2³¹ - 1 
// b != 0 
// 
//
// 
//
// 注意：本题与主站 29 题相同：https://leetcode-cn.com/problems/divide-two-integers/ 
//
// 
// Related Topics 位运算 数学 👍 45 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOfferII001ZhengShuChuFa {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOfferII001ZhengShuChuFa().new Solution();
        solution.divide(-2147483648, -1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int a, int b) {
            if (a == 0 || b == 0) {
                return 0;
            }
            long A = a;
            long B = b;

            A = Math.abs(A);
            B = Math.abs(B);

            long md = 0;
            if (A >= B) {
                if (B == 1) {
                    md = A;
                } else {
                    long k = A;
                    while (k >= B) {
                        k = k - B;
                        md++;
                    }
                }
            } else {
                return 0;
            }

            if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
                return md > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) md;
            } else {
                return md > Integer.MAX_VALUE ? Integer.MIN_VALUE : (int) -md;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}