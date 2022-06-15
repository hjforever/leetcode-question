//The distance of a pair of integers a and b is defined as the absolute
//difference between a and b. 
//
// Given an integer array nums and an integer k, return the kᵗʰ smallest 
//distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,1], k = 1
//Output: 0
//Explanation: Here are all the pairs:
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//Then the 1ˢᵗ smallest distance pair is (1,1), and its distance is 0.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1], k = 2
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1,6,1], k = 3
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 10⁴ 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= n * (n - 1) / 2 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 288 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q719FindKThSmallestPairDistance {
    public static void main(String[] args) {
        Solution solution = new Q719FindKThSmallestPairDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {

            // sort, binary search , two pointers

            // abs(i,j)等价于 排序后的i,j
            Arrays.sort(nums);
            //对k进行二分
            int l = 0;
            int r = (int) 1e6;
            while (l < r) {
                int mid = l + r >> 1;
                if (check(nums, mid) >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }

        int check(int[] nums, int target) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0, j = 1; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= target) j++;
                ans += (j - i - 1);
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}