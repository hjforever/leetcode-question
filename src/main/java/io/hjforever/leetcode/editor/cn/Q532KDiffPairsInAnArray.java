//Given an array of integers nums and an integer k, return the number of unique
//k-diff pairs in the array. 
//
// A k-diff pair is an integer pair (nums[i], nums[j]), where the following are 
//true: 
//
// 
// 0 <= i, j < .length
// i != j nums
// nums[i] - nums[j] == k 
// 
//
// Notice that |val| denotes the absolute value of val. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,4,1,5], k = 2
//Output: 2
//Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
//Although we have two 1s in the input, we should only return the number of 
//unique pairs.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], k = 1
//Output: 4
//Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) 
//and (4, 5).
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,1,5,4], k = 0
//Output: 1
//Explanation: There is one 0-diff pair in the array, (1, 1).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁷ <= nums[i] <= 10⁷ 
// 0 <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 165 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q532KDiffPairsInAnArray {
    public static void main(String[] args) {
        Solution solution = new Q532KDiffPairsInAnArray().new Solution();
        solution.findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPairs(int[] nums, int k) {
            //hash
            Set<Integer> pre = new HashSet<>();
            Set<Integer> ans = new HashSet<>();
            for (int num : nums) {
                if (pre.contains(num - k)) {
                    ans.add(num - k);
                }
                if (pre.contains(num + k)) {
                    ans.add(num);
                }
                pre.add(num);
            }
            return ans.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}