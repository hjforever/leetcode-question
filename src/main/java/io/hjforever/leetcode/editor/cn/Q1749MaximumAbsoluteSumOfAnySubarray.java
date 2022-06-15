//You are given an integer array nums. The absolute sum of a subarray [numsl,
//numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr). 
//
// Return the maximum absolute sum of any (possibly empty) subarray of nums. 
//
// Note that abs(x) is defined as follows: 
//
// 
// If x is a negative integer, then abs(x) = -x. 
// If x is a non-negative integer, then abs(x) = x. 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-3,2,3,-4]
//Output: 5
//Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,-5,1,-4,3,-2]
//Output: 8
//Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) =
// 8.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 动态规划 👍 24 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1749MaximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args) {
        Solution solution = new Q1749MaximumAbsoluteSumOfAnySubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            //求max，min
            int n = nums.length;

            // 1.dp
//            int[][] dp = new int[n][2];
//            dp[0][0] = nums[0];
//            dp[0][1] = nums[0];
//            int ans = Math.abs(nums[0]);
//            for (int i = 1; i < n; i++) {
//                dp[i][0] = Math.max(nums[i], nums[i] + dp[i - 1][0]);
//                dp[i][1] = Math.min(nums[i], nums[i] + dp[i - 1][1]);
//                ans = Math.max(ans, Math.abs(dp[i][0]));
//                ans = Math.max(ans, Math.abs(dp[i][1]));
//            }

            //2. presum, presum(max) - presum(min)
            int pre = 0, max = 0, min = 0;
            for (int num : nums) {
                pre += num;
                if (pre > max) {
                    max = pre;
                }
                if (pre < min) {
                    min = pre;
                }
            }
            return max - min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}