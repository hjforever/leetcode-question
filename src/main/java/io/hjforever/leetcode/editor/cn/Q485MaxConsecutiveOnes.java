//Given a binary array nums, return the maximum number of consecutive 1's in
//the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s.
// The maximum number of consecutive 1s is 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1,0,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
// Related Topics 数组 👍 318 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q485MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new Q485MaxConsecutiveOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            //array
            int res = 0;
            int n = nums.length;

            int count = 0;
            int j = 0;

            while (j < n) {
                if (nums[j] == 1) {
                    count++;
                } else {
                    res = Math.max(res, count);
                    count = 0;
                }
                j++;
            }
            res = Math.max(res, count);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}