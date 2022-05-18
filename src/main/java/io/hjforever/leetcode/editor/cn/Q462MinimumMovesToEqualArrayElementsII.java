//Given an integer array nums of size n, return the minimum number of moves
//required to make all array elements equal. 
//
// In one move, you can increment or decrement an element of the array by 1. 
//
// Test cases are designed so that the answer will fit in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 2
//Explanation:
//Only two moves are needed (remember each move increments or decrements one 
//element):
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,10,2,9]
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 数学 排序 👍 160 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q462MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args) {
        Solution solution = new Q462MinimumMovesToEqualArrayElementsII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minMoves2(int[] nums) {
            //binary search
            //求最低值
            if (nums == null || nums.length == 1) return 0;
            int n = nums.length;
            int left = (int) (-1e9 - 1);
            int right = (int) (1e9 + 1);

            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (cnt(nums, mid) > cnt(nums, mid + 1)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return (int) cnt(nums, left);
        }

        long cnt(int[] nums, int target) {
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.abs(target - nums[i]);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}