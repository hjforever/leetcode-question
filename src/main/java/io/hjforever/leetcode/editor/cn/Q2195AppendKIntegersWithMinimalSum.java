//You are given an integer array nums and an integer k. Append k unique
//positive integers that do not appear in nums to nums such that the resulting total sum 
//is minimum. 
//
// Return the sum of the k integers appended to nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,4,25,10,25], k = 2
//Output: 5
//Explanation: The two unique positive integers that do not appear in nums 
//which we append are 2 and 3.
//The resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the 
//minimum.
//The sum of the two integers appended is 2 + 3 = 5, so we return 5. 
//
// Example 2: 
//
// 
//Input: nums = [5,6], k = 6
//Output: 25
//Explanation: The six unique positive integers that do not appear in nums 
//which we append are 1, 2, 3, 4, 7, and 8.
//The resulting sum of nums is 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36, which is the 
//minimum. 
//The sum of the six integers appended is 1 + 2 + 3 + 4 + 7 + 8 = 25, so we 
//return 25.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁸ 
// 
// Related Topics 贪心 数组 数学 排序 👍 31 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q2195AppendKIntegersWithMinimalSum {
    public static void main(String[] args) {
        Solution solution = new Q2195AppendKIntegersWithMinimalSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimalKSum(int[] nums, int k) {
            //sort, greedy
            Arrays.sort(nums);
            long ans = 0, start = 1;
            for (int i = 0; i < nums.length && k > 0; i++) {
                // 存在未出现的数字
                if (start < nums[i]) {
                    int cnt = Math.min((int) (nums[i] - start), k);
                    // 不存在的数据累计
                    ans += (2L * start + cnt - 1) * cnt / 2;
                    k -= cnt;
                }
                start = nums[i] + 1;
            }
            // 不存在的数据累计
            if (k > 0) {
                ans += (2L * start + k - 1) * k / 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}