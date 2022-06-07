//Given an array nums of integers, a move consists of choosing any element and
//decreasing it by 1. 
//
// An array A is a zigzag array if either: 
//
// 
// Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1]
// < A[2] > A[3] < A[4] > ... 
// OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < 
//A[1] > A[2] < A[3] > A[4] < ... 
// 
//
// Return the minimum number of moves to transform the given array nums into a 
//zigzag array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 2
//Explanation: We can decrease 2 to 0 or 3 to 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [9,6,1,6,2]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 👍 40 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1144DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {
        Solution solution = new Q1144DecreaseElementsToMakeArrayZigzag().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            int left;
            int right;
            int oddNumberCount = 0;
            int evenNumberCount = 0;
            for (int i = 0; i < nums.length; i++) {
                left = i - 1;
                right = i + 1;
                int leftGap = 0;
                int rightGap = 0;
                //计算自身比左边大多少->自身需要递减几步能达到小于左边
                if (left >= 0) {
                    leftGap = Math.max(nums[i] - nums[left] + 1, 0);
                }
                //计算自身比右边大多少->自身需要递减几步能达到小于右边
                if (right <= nums.length - 1) {
                    rightGap = Math.max(nums[i] - nums[right] + 1, 0);
                }
                //如果自身时偶数，则count在偶数需要递减的次数
                if (i % 2 == 0) {
                    evenNumberCount += Math.max(leftGap, rightGap);
                } else {
                    //否则，则count在奇数需要递减的次数
                    oddNumberCount += Math.max(leftGap, rightGap);
                }
            }
            //返回小值
            return Math.min(oddNumberCount, evenNumberCount);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}