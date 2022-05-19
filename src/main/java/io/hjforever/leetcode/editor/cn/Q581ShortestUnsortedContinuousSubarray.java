//Given an integer array nums, you need to find one continuous subarray that if
//you only sort this subarray in ascending order, then the whole array will be 
//sorted in ascending order. 
//
// Return the shortest such subarray and output its length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
//whole array sorted in ascending order.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//Follow up: Can you solve it in O(n) time complexity? Related Topics 栈 贪心 数组 双指
//针 排序 单调栈 👍 854 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q581ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new Q581ShortestUnsortedContinuousSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            //单调栈 双指针
            int n = nums.length;
            int l = n, r = -1;
            int Min = Integer.MAX_VALUE, Max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                //寻找右边界
                if (nums[i] >= Max) {
                    Max = nums[i];
                } else {
                    r = i;
                }
                //寻找左边界
                if (nums[n - 1 - i] <= Min) {
                    Min = nums[n - 1 - i];
                } else {
                    l = n - 1 - i;
                }
            }
            return r == -1 ? 0 : r - l + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}