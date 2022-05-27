//You are given an integer array nums where the iᵗʰ bag contains nums[i] balls.
//You are also given an integer maxOperations. 
//
// You can perform the following operation at most maxOperations times: 
//
// 
// Take any bag of balls and divide it into two new bags with a positive number 
//of balls.
//
// 
// For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or 
//two new bags of 2 and 3 balls. 
// 
// 
// 
//
// Your penalty is the maximum number of balls in a bag. You want to minimize 
//your penalty after the operations. 
//
// Return the minimum possible penalty after performing the operations. 
//
// 
// Example 1: 
//
// 
//Input: nums = [9], maxOperations = 2
//Output: 3
//Explanation: 
//- Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
//- Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3]
//.
//The bag with the most number of balls has 3 balls, so your penalty is 3 and 
//you should return 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,4,8,2], maxOperations = 4
//Output: 2
//Explanation:
//- Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,
//4,4,4,2].
//- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [
//2,2,2,4,4,2].
//- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] ->
// [2,2,2,2,2,4,2].
//- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] 
//-> [2,2,2,2,2,2,2,2].
//The bag with the most number of balls has 2 balls, so your penalty is 2 an 
//you should return 2.
// 
//
// Example 3: 
//
// 
//Input: nums = [7,17], maxOperations = 2
//Output: 7
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= maxOperations, nums[i] <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 81 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1760MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        Solution solution = new Q1760MinimumLimitOfBallsInABag().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            // binary search
            int n = nums.length;
            int left = 1;
            int right = (int) (1e9 + 10);
            //求右边界
            while (left < right) {
                int mid = (right - left) / 2 + left;
                int count = count(nums, mid);
                if (count <= maxOperations) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        //计算最多需要的操作次数，小于或等于maxOperations则表示可操作性
        public int count(int[] nums, int value) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                //nums[i] % value == 0 ? nums[i] / value - 1 : nums[i] / value
                //     eq
                // (nums[i]-1)/value
                //效率提升不少，%对性能影响太大
                count += (nums[i] - 1) / value;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}