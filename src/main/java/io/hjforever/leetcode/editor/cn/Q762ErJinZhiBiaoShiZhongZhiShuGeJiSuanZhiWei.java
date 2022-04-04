//给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
//
// 计算置位位数 就是二进制表示中 1 的个数。 
//
// 
// 例如， 21 的二进制表示 10101 有 3 个计算置位。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 6, right = 10
//输出：4
//解释：
//6 -> 110 (2 个计算置位，2 是质数)
//7 -> 111 (3 个计算置位，3 是质数)
//9 -> 1001 (2 个计算置位，2 是质数)
//10-> 1010 (2 个计算置位，2 是质数)
//共计 4 个计算置位为质数的数字。
// 
//
// 示例 2： 
//
// 
//输入：left = 10, right = 15
//输出：5
//解释：
//10 -> 1010 (2 个计算置位, 2 是质数)
//11 -> 1011 (3 个计算置位, 3 是质数)
//12 -> 1100 (2 个计算置位, 2 是质数)
//13 -> 1101 (3 个计算置位, 3 是质数)
//14 -> 1110 (3 个计算置位, 3 是质数)
//15 -> 1111 (4 个计算置位, 4 不是质数)
//共计 5 个计算置位为质数的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= left <= right <= 10⁶ 
// 0 <= right - left <= 10⁴ 
// 
// Related Topics 位运算 数学 👍 72 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q762ErJinZhiBiaoShiZhongZhiShuGeJiSuanZhiWei {
    public static void main(String[] args) {
        Solution solution = new Q762ErJinZhiBiaoShiZhongZhiShuGeJiSuanZhiWei().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Integer> set = new HashSet<>();

        public Solution() {
            int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
            for (int i = 0; i < prime.length; i++) {
                set.add(prime[i]);
            }
        }

        public int countPrimeSetBits(int left, int right) {
            //因为i最大为32位 则可以初始化32以内的素数
            int res = 0;
            //求数字位为1的个数且是素数
            for (int i = left; i <= right; i++) {
                int count = Integer.bitCount(i);
                //判断是否为素数
                if (set.contains(count)) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}