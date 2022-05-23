//Given an integer array nums, partition it into two (contiguous) subarrays
//left and right so that: 
//
// 
// Every element in left is less than or equal to every element in right. 
// left and right are non-empty. 
// left has the smallest possible size. 
// 
//
// Return the length of left after such a partitioning. 
//
// Test cases are generated such that partitioning exists. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,0,3,8,6]
//Output: 3
//Explanation: left = [5,0,3], right = [8,6]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1,0,6,12]
//Output: 4
//Explanation: left = [1,1,1,0], right = [6,12]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// There is at least one valid answer for the given input. 
// 
// Related Topics 数组 👍 95 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q915PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        Solution solution = new Q915PartitionArrayIntoDisjointIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int[] low = new int[n];
            int[] high = new int[n];

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                high[i] = max;
            }

            int min = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] < min) {
                    min = nums[i];
                }
                low[i] = min;
            }

            //右边最小值 大于左边最大值
            for (int i = 0; i < n - 1; i++) {
                if (low[i + 1] >= high[i]) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}