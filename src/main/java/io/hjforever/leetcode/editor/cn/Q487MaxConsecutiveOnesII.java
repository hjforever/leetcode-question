//Given a binary array nums, return the maximum number of consecutive 1's in
//the array if you can flip at most one 0. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,1,1,0]
//Output: 4
//Explanation: Flip the first zero will get the maximum number of consecutive 1
//s. After flipping, the maximum number of consecutive 1s is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1,0,1]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
//
// 
// Follow up: What if the input numbers come in one by one as an infinite 
//stream? In other words, you can't store all numbers coming from the stream as it's 
//too large to hold in memory. Could you solve it efficiently? 
// Related Topics 数组 动态规划 滑动窗口 👍 106 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q487MaxConsecutiveOnesII {
    public static void main(String[] args) {
        Solution solution = new Q487MaxConsecutiveOnesII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            // sliding window
            int n = nums.length;
            int l = 0, r = 0, ans = 0;
            int count = 0;
            while (r < n) {
                int num = nums[r];
                if (num == 0) count++;
                while (count > 1) {
                    if (nums[l++] == 0) {
                        count--;
                    }
                }
                ans = Math.max(ans, r - l + 1);
                r++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}