//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 👍 646 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q60PaiLieXuLie {
    public static void main(String[] args) {
        Solution solution = new Q60PaiLieXuLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            k--;
            //题目给的k是第k个 也就是数量，我们要给他转成序列号k-1；
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; ++i) {
                dp[i] = dp[i - 1] * i;
            }
            //构建阶层数组dp 因为我们只需要用到n-1 阶层 所以这里dp只需要n个就行
            int[] nums = new int[n];
            for (int i = 1; i <= n; i++) {
                nums[i - 1] = i;
            }

            //构建1-n每个数字的数组nums 。到时候我们要一个个取出来转成string 然后从数组里清除掉。
            StringBuilder builder = new StringBuilder();
            while (n-- > 0) {
                //第一次进入循环 这个n就已经是n-1了
                int ord = k / dp[n];
                builder.append(nums[ord]);
                for (int j = ord; j < n; ++j) {
                    nums[j] = nums[j + 1];
                }
                //这是数组最原始的删除一个位置元素的方式。
                k %= dp[n];
            }
            return builder.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}