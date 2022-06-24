//Given an integer array nums and two integers firstLen and secondLen, return
//the maximum sum of elements in two non-overlapping subarrays with lengths 
//firstLen and secondLen. 
//
// The array with length firstLen could occur before or after the array with 
//length secondLen, but they have to be non-overlapping. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
//Output: 20
//Explanation: One choice of subarrays is [9] with length 1, and [6,5] with 
//length 2.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
//Output: 29
//Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with 
//length 2.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
//Output: 31
//Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [0,3,8] 
//with length 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= firstLen, secondLen <= 1000 
// 2 <= firstLen + secondLen <= 1000 
// firstLen + secondLen <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 滑动窗口 👍 133 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1031MaximumSumOfTwoNonOverlappingSubarrays {
    public static void main(String[] args) {
        Solution solution = new Q1031MaximumSumOfTwoNonOverlappingSubarrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int L, int M) {
            //前缀和，枚举两个端点
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            int ans = 0;
            int maxL = 0;
            int maxM = 0;
            //枚举两个端点
            //1.如果是长L的在前,长M的在后
            for (int i = L; i + M <= n; i++) {
                maxL = Math.max(maxL, sum[i] - sum[i - L]);
                ans = Math.max(ans, maxL + sum[i + M] - sum[i]);
            }
            //如果是长M的在前,长L的在后
            for (int i = M; i + L <= n; i++) {
                maxM = Math.max(maxM, sum[i] - sum[i - M]);
                ans = Math.max(ans, maxM + sum[i + L] - sum[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}