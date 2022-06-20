//Given a binary array nums and an integer goal, return the number of non-empty
//subarrays with a sum goal. 
//
// A subarray is a contiguous part of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,1,0,1], goal = 2
//Output: 4
//Explanation: The 4 subarrays are bolded and underlined below:
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0,0,0], goal = 0
//Output: 15
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// nums[i] is either 0 or 1. 
// 0 <= goal <= nums.length 
// Related Topics 数组 哈希表 前缀和 滑动窗口 👍 244 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q930BinarySubarraysWithSum {
    public static void main(String[] args) {
        Solution solution = new Q930BinarySubarraysWithSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            // prefix , map
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if (sum == goal) {
                    ans++;
                }
                if (map.containsKey(sum - goal)) {
                    ans += map.get(sum - goal);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}