//You are given a sorted array nums of n non-negative integers and an integer
//maximumBit. You want to perform the following query n times: 
//
// 
// Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] 
//XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the iᵗʰ 
//query. 
// Remove the last element from the current array nums. 
// 
//
// Return an array answer, where answer[i] is the answer to the iᵗʰ query. 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,1,3], maximumBit = 2
//Output: [0,3,2,3]
//Explanation: The queries are answered as follows:
//1ˢᵗ query: nums = [0,1,1,3], k = 0 since 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3.
//2ⁿᵈ query: nums = [0,1,1], k = 3 since 0 XOR 1 XOR 1 XOR 3 = 3.
//3ʳᵈ query: nums = [0,1], k = 2 since 0 XOR 1 XOR 2 = 3.
//4ᵗʰ query: nums = [0], k = 3 since 0 XOR 3 = 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,4,7], maximumBit = 3
//Output: [5,2,6,5]
//Explanation: The queries are answered as follows:
//1ˢᵗ query: nums = [2,3,4,7], k = 5 since 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7.
//2ⁿᵈ query: nums = [2,3,4], k = 2 since 2 XOR 3 XOR 4 XOR 2 = 7.
//3ʳᵈ query: nums = [2,3], k = 6 since 2 XOR 3 XOR 6 = 7.
//4ᵗʰ query: nums = [2], k = 5 since 2 XOR 5 = 7.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,1,2,2,5,7], maximumBit = 3
//Output: [4,3,6,4,6,7]
// 
//
// 
// Constraints: 
//
// 
// nums.length == n 
// 1 <= n <= 10⁵ 
// 1 <= maximumBit <= 20 
// 0 <= nums[i] < 2maximumBit 
// nums is sorted in ascending order. 
// 
// Related Topics 位运算 数组 前缀和 👍 20 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1829MaximumXORForEachQuery {
    public static void main(String[] args) {
        Solution solution = new Q1829MaximumXORForEachQuery().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int a = (int) Math.pow(2, maximumBit) - 1;
            int k = 0;
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                k ^= nums[i];
                ans[nums.length - 1 - i] = a - k;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}