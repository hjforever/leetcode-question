//The score of an array is defined as the product of its sum and its length.
//
// 
// For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75. 
// 
//
// Given a positive integer array nums and an integer k, return the number of 
//non-empty subarrays of nums whose score is strictly less than k. 
//
// A subarray is a contiguous sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,1,4,3,5], k = 10
//Output: 6
//Explanation:
//The 6 subarrays having scores less than 10 are:
//- [2] with score 2 * 1 = 2.
//- [1] with score 1 * 1 = 1.
//- [4] with score 4 * 1 = 4.
//- [3] with score 3 * 1 = 3. 
//- [5] with score 5 * 1 = 5.
//- [2,1] with score (2 + 1) * 2 = 6.
//Note that subarrays such as [1,4] and [4,3,5] are not considered because 
//their scores are 10 and 36 respectively, while we need scores strictly less than 10. 
//
//
// Example 2: 
//
// 
//Input: nums = [1,1,1], k = 5
//Output: 5
//Explanation:
//Every subarray except [1,1,1] has a score less than 5.
//[1,1,1] has a score (1 + 1 + 1) * 3 = 9, which is greater than 5.
//Thus, there are 5 subarrays having scores less than 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 1 <= k <= 10¹⁵ 
// 
// 👍 1 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q6098CountSubarraysWithScoreLessThanK {
    public static void main(String[] args) {
        Solution solution = new Q6098CountSubarraysWithScoreLessThanK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countSubarrays(int[] nums, long k) {
            //prefix sum , sliding window
            int n = nums.length;
            long[] pre = new long[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + nums[i];
            }
            long ans = 0;
            int l = 0, r = 0;
            while (r < n) {
                while (l <= r && (pre[r + 1] - pre[l]) * (r - l + 1) >= k) {
                    l++;
                }
                ans += (r - l + 1);
                r++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}