//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 225 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q400DiNWeiShuZi {
    public static void main(String[] args) {
        Solution solution = new Q400DiNWeiShuZi().new Solution();

        //int n = solution.findNum(129, 2);
        int n = solution.findNthDigit(11);
        System.out.println(n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            if (n >= 1 && n <= 9) {
                return n;
            }
            // 1*9 , 90 * 2 , 3 * 90 , 4*900

            //
            long k = n;
            long cnt = 1;
            long base = 9;

            k = k - 9;
            while (true) {
                cnt = cnt + 1;
                base *= 10;
                if (k > base * cnt) {
                    k -= base * cnt;
                } else {
                    int mod = (int) (k % cnt);
                    long start = (long) Math.pow(10, cnt-1);
                    long next;
                    if (mod == 0) {
                        next = start + k / cnt -1 ;
                        return (int) (next % 10);
                    } else {
                        next = start + k / cnt ;
                        return findNum(next, mod);
                    }
                }
            }
        }

        int findNum(long num, int pos) {
            String numStr = String.valueOf(num);
            return Integer.valueOf("" + numStr.charAt(pos-1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}