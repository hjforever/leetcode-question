//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 253 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q367YouXiaoDeWanQuanPingFangShu {
    public static void main(String[] args) {
        Solution solution = new Q367YouXiaoDeWanQuanPingFangShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            //二分
            int left = 0, right = num;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                //此处需要用long,防止溢出
                long sq = (long) mid * mid;
                if (sq < num) {
                    left = mid + 1;
                } else if (sq > num) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}