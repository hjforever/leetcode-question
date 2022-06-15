//You are given an integer array nums of length n which represents a
//permutation of all the integers in the range [0, n - 1]. 
//
// The number of global inversions is the number of the different pairs (i, j) 
//where: 
//
// 
// 0 <= i < j < n 
// nums[i] > nums[j] 
// 
//
// The number of local inversions is the number of indices i where: 
//
// 
// 0 <= i < n - 1 
// nums[i] > nums[i + 1] 
// 
//
// Return true if the number of global inversions is equal to the number of 
//local inversions. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,2]
//Output: true
//Explanation: There is 1 global inversion and 1 local inversion.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,0]
//Output: false
//Explanation: There are 2 global inversions and 1 local inversion.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] < n 
// All the integers of nums are unique. 
// nums is a permutation of all the numbers in the range [0, n - 1]. 
// 
// Related Topics 数组 数学 👍 84 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q775GlobalAndLocalInversions {
    public static void main(String[] args) {
        Solution solution = new Q775GlobalAndLocalInversions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            int n = nums.length;
            //局部倒置 也是 全局倒置
            // 必须保证后面的数字一定要大于等于前面的数字，eg. 3,2,4,3,5,4
            //则通过反向查询即 前面的数字一定要小于或等于最小值
            //从右往左遍历数组 A，保存见到的最小的数。定义 floor = min(A[i:]) 来保存最小的数，
            // 如果 A[i-2] > floor，直接返回 False，当遍历结束都没有返回 False，返回 True。
            int floor = n;
            for (int i = n - 1; i >= 2; i--) {
                floor = Math.min(floor, nums[i]);
                if (nums[i - 2] > floor) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}