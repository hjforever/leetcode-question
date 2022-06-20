//Given a binary array nums and an integer k, return the maximum number of
//consecutive 1's in the array if you can flip at most k 0's. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined. 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 0 <= k <= nums.length 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 429 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1004MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        Solution solution = new Q1004MaxConsecutiveOnesIII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            //sliding window
            int n = nums.length;
            int left = 0;
            int right = 0;
            int zCnt = 0;
            int ans = 0;
            while (right < n) {
                zCnt += nums[right] == 0 ? 1 : 0;
                while (zCnt > k) {
                    int num = nums[left++];
                    if (num == 0) zCnt--;
                }
                ans = Math.max(right - left + 1, ans);
                right++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}