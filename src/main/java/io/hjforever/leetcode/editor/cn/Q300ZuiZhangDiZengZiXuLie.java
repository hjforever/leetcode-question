//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2135 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q300ZuiZhangDiZengZiXuLie {
    public static void main(String[] args) {
        Solution solution = new Q300ZuiZhangDiZengZiXuLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            //dp(i) = (dp(j)+1) && i>j , nums[i]>nums[j]
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return 1;
            int n = nums.length;
            int[] dp = new int[n];
            int res = 1 ;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                res = Math.max(dp[i], res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}