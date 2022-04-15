//给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 2
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics 位运算 数学 👍 602 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q371LiangZhengShuZhiHe {
    public static void main(String[] args) {
        Solution solution = new Q371LiangZhengShuZhiHe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            //without using the operator + and -
            //bit wise
            // a & b 相当于进位 各个位置是否要进位，进位则需要左移一位
            // a ^ b 相当于相加后的结果不考虑进位
            // ((a&b) <<1 ) ^ a

            while (b != 0) {
                int c = (a & b) << 1;
                a = a ^ b;
                b = c;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}