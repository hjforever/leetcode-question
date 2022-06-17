//You are given an integer array nums. The range of a subarray of nums is the
//difference between the largest and smallest element in the subarray. 
//
// Return the sum of all subarray ranges of nums. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 4
//Explanation: The 6 subarrays of nums are the following:
//[1], range = largest - smallest = 1 - 1 = 0 
//[2], range = 2 - 2 = 0
//[3], range = 3 - 3 = 0
//[1,2], range = 2 - 1 = 1
//[2,3], range = 3 - 2 = 1
//[1,2,3], range = 3 - 1 = 2
//So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4. 
//
// Example 2: 
//
// 
//Input: nums = [1,3,3]
//Output: 4
//Explanation: The 6 subarrays of nums are the following:
//[1], range = largest - smallest = 1 - 1 = 0
//[3], range = 3 - 3 = 0
//[3], range = 3 - 3 = 0
//[1,3], range = 3 - 1 = 2
//[3,3], range = 3 - 3 = 0
//[1,3,3], range = 3 - 1 = 2
//So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
// 
//
// Example 3: 
//
// 
//Input: nums = [4,-2,-3,4,1]
//Output: 59
//Explanation: The sum of all subarray ranges of nums is 59.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
// Follow-up: Could you find a solution with O(n) time complexity? 
// Related Topics 栈 数组 单调栈 👍 199 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2104SumOfSubarrayRanges {
    public static void main(String[] args) {
        Solution solution = new Q2104SumOfSubarrayRanges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long subArrayRanges(int[] nums) {

            //1.暴力
            long ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int min = nums[i];
                int max = nums[i];
                for (int j = i; j < nums.length; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    ans += (max - min);
                }
            }
            return ans;
            //TODO
            //单调栈
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}