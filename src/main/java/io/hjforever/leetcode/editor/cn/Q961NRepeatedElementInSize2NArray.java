//You are given an integer array nums with the following properties:
//
// 
// nums.length == 2 * n. 
// nums contains n + 1 unique elements. 
// Exactly one element of nums is repeated n times. 
// 
//
// Return the element that is repeated n times. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,3]
//Output: 3
// Example 2: 
// Input: nums = [2,1,2,5,3,2]
//Output: 2
// Example 3: 
// Input: nums = [5,1,5,2,5,3,5,4]
//Output: 5
// 
// 
// Constraints: 
//
// 
// 2 <= n <= 5000 
// nums.length == 2 * n 
// 0 <= nums[i] <= 10⁴ 
// nums contains n + 1 unique elements and one of them is repeated exactly n 
//times. 
// 
// Related Topics 数组 哈希表 👍 115 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q961NRepeatedElementInSize2NArray {
    public static void main(String[] args) {
        Solution solution = new Q961NRepeatedElementInSize2NArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int repeatedNTimes(int[] nums) {
            // map, 题目没什么意义
            int n = nums.length;
            Map<Integer, Integer> cnt = new HashMap();
            for (int num : nums) {
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
            for (int num : cnt.keySet()) {
                if (cnt.get(num) == n / 2) {
                    return num;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}