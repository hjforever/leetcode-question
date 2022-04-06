//给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
//
// 子数组 定义为原数组中的一个连续子序列。 
//
// 请你返回 arr 中 所有奇数长度子数组的和 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,4,2,5,3]
//输出：58
//解释：所有奇数长度子数组和它们的和为：
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：3
//解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。 
//
// 示例 3： 
//
// 输入：arr = [10,11,12]
//输出：66
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 1000 
// 
// Related Topics 数组 数学 前缀和 👍 169 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1588SuoYouQiShuZhangDuZiShuZuDeHe {
    public static void main(String[] args) {
        Solution solution = new Q1588SuoYouQiShuZhangDuZiShuZuDeHe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            // prefix sum
            // sum(i,j) = sum(j)-sum(i-1)
            int n = arr.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < arr.length; i++) {
                sum[i + 1] = arr[i] + sum[i];
            }
            if (n <= 2) {
                return sum[n];
            }
            int total = 0;
            // 取一个
            total += sum[n];
            int count = 3;
            while (n >= count) {
                for (int i = 1; i <= (n + 1) - count; i++) {
                    total += (sum[i + count - 1] - sum[i - 1]);
                }
                count += 2;
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}