//Given a sorted integer array nums and three integers a, b and c, apply a
//quadratic function of the form f(x) = ax² + bx + c to each element nums[i] in the 
//array, and return the array in a sorted order. 
//
// 
// Example 1: 
// Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
//Output: [3,9,15,33]
// Example 2: 
// Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
//Output: [-23,-5,1,7]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -100 <= nums[i], a, b, c <= 100 
// nums is sorted in ascending order. 
// 
//
// 
// Follow up: Could you solve it in O(n) time? 
// Related Topics 数组 数学 双指针 排序 👍 59 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q360SortTransformedArray {
    public static void main(String[] args) {
        Solution solution = new Q360SortTransformedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            // math
            // 把 nums[] 看成横坐标，把 ans[] 看成纵坐标
            int[] ans = new int[nums.length];
            int index;
            if (a == 0) {  // a==0 是直线
                if (b > 0) {   // 斜率为正，单调递增
                    index = 0;
                    for (int num : nums) {
                        ans[index++] = cal(num, a, b, c);
                    }
                } else if (b < 0) {    // 斜率为负，单调递减
                    index = nums.length - 1;
                    for (int num : nums) {
                        ans[index--] = cal(num, a, b, c);
                    }
                } else { // 水平直线
                    Arrays.fill(ans, c);
                }
            } else {  // a != 0 是抛物线
                double midVal = -b * (1.0 / (2 * a));   // -b/2a 是抛物线的最值
                int left = 0;
                int right = nums.length - 1;
                if (a > 0) {    // 开口向上，有最小值
                    index = nums.length - 1;    // 从最大值往下装入 ans 中
                    while (left <= right) {
                        // x 距离中心横坐标越远的，y 越大
                        if (Math.abs(midVal - nums[left]) > Math.abs(midVal - nums[right])) {
                            ans[index] = cal(nums[left], a, b, c);
                            left++;
                        } else {
                            ans[index] = cal(nums[right], a, b, c);
                            right--;
                        }
                        index--;
                    }
                } else {    // 开口向下，有最大值
                    index = 0;
                    while (left <= right) {
                        // x 距离中心横坐标越远的，y 越小
                        if (Math.abs(midVal - nums[left]) > Math.abs(midVal - nums[right])) {
                            ans[index] = cal(nums[left], a, b, c);
                            left++;
                        } else {
                            ans[index] = cal(nums[right], a, b, c);
                            right--;
                        }
                        index++;
                    }
                }
            }
            return ans;
        }

        public int cal(int x, int a, int b, int c) {
            // ax² + bx + c
            return a * x * x + b * x + c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}