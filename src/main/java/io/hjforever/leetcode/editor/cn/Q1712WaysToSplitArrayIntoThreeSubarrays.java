//A split of an integer array is good if:
//
// 
// The array is split into three non-empty contiguous subarrays - named left, 
//mid, right respectively from left to right. 
// The sum of the elements in left is less than or equal to the sum of the 
//elements in mid, and the sum of the elements in mid is less than or equal to the sum 
//of the elements in right. 
// 
//
// Given nums, an array of non-negative integers, return the number of good 
//ways to split nums. As the number may be too large, return it modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1]
//Output: 1
//Explanation: The only good way to split nums is [1] [1] [1]. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,2,2,5,0]
//Output: 3
//Explanation: There are three good ways of splitting nums:
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,2,1]
//Output: 0
//Explanation: There is no good way to split nums. 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁴ 
// Related Topics 数组 双指针 二分查找 前缀和 👍 72 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1712WaysToSplitArrayIntoThreeSubarrays {
    public static void main(String[] args) {
        Solution solution = new Q1712WaysToSplitArrayIntoThreeSubarrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToSplit(int[] nums) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            final int MOD = 1000000000 + 7;
            long ans = 0;
            // |______|________|_______|________|
            // 1      i        l       r        n
            // i 表示第一刀的位置，枚举第一刀的位置，计算第二刀的可选位置数
            for (int i = 1, l = 2, r = 2; i <= n - 1; i++) {
                l = Math.max(l, i + 1);
                r = Math.max(r, i + 1);
                // sum(right) >= sum(mid)，r最大为n-1，right保证要有一个数
                while (r <= n - 1 && sum[n] - sum[r] >= sum[r] - sum[i]) {
                    r++;
                }
                // sum(mid) >= sum(left)
                while (l <= n - 1 && sum[l] - sum[i] < sum[i]) {
                    l++;
                }
                if (l <= r) {
                    ans += r - l;
                }
            }
            return (int) (ans % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}