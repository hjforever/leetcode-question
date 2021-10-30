//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 986 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new Q416PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{23, 13, 11, 7, 6, 5, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums.length < 2) {
                return false;
            }
            int sum = 0;
            int maxNum = nums[0];
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                maxNum = Math.max(maxNum, nums[i]);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = (sum / 2);
            if (maxNum > target) {
                return false;
            }
            boolean[] dp = new boolean[target + 1];
            //当为0则为true
            dp[0] = true;
            //dp[j] = dp[j] | dp[j-nums[i]]
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                for (int j = target; j >= num; --j) {
                    dp[j] |= dp[j - num];
                }
            }
            return dp[target];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}