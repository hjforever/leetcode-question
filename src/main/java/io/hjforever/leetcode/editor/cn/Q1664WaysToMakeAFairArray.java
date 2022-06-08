//You are given an integer array nums. You can choose exactly one index (0-
//indexed) and remove the element. Notice that the index of the elements may change 
//after the removal. 
//
// For example, if nums = [6,1,7,4,1]: 
//
// 
// Choosing to remove index 1 results in nums = [6,7,4,1]. 
// Choosing to remove index 2 results in nums = [6,1,4,1]. 
// Choosing to remove index 4 results in nums = [6,1,7,4]. 
// 
//
// An array is fair if the sum of the odd-indexed values equals the sum of the 
//even-indexed values. 
//
// Return the number of indices that you could choose such that after the 
//removal, nums is fair. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,1,6,4]
//Output: 1
//Explanation:
//Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
//Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
//Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
//Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
//There is 1 index that you can remove to make nums fair.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1]
//Output: 3
//Explanation: You can remove any index and the remaining array is fair.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3]
//Output: 0
//Explanation: You cannot make a fair array after removing any index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 动态规划 👍 32 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1664WaysToMakeAFairArray {
    public static void main(String[] args) {
        Solution solution = new Q1664WaysToMakeAFairArray().new Solution();
        solution.waysToMakeFair(new int[]{2, 1, 6, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToMakeFair(int[] nums) {
            //prefix sum
            int n = nums.length;
            int[] oddSum = new int[n];
            int[] evenSum = new int[n];

            evenSum[0] = 0;
            oddSum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) {
                    oddSum[i] = nums[i] + oddSum[i - 1];
                    evenSum[i] = evenSum[i - 1];
                } else {
                    oddSum[i] = oddSum[i - 1];
                    evenSum[i] = evenSum[i - 1] + nums[i];
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int righteven = oddSum[n - 1] - oddSum[i];
                int rightodd = evenSum[n - 1] - evenSum[i];
                if (i % 2 == 0) {
                    int leftodd = oddSum[i] - nums[i];
                    int lefteven = evenSum[i];
                    if (lefteven + righteven == leftodd + rightodd) {
                        ans++;
                    }
                } else {
                    int lefteven = evenSum[i] - nums[i];
                    int leftodd = oddSum[i];
                    if (lefteven + righteven == leftodd + rightodd) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}