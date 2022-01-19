//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 948 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q16ZuiJieJinDeSanShuZhiHe {
    public static void main(String[] args) {
        Solution solution = new Q16ZuiJieJinDeSanShuZhiHe().new Solution();
        solution.threeSumClosest(new int[]{-1, 2, 1, 4}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) return 0;
            Arrays.sort(nums);
            int closestSum = Integer.MAX_VALUE;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int k = target - num;
                int left = 0;
                int right = nums.length - 1;
                while (left < right) {
                    if (left == i) {
                        left++;
                    }
                    if (right == i) {
                        right--;
                    }
                    if (left >= right) break;
                    int sum = nums[left] + nums[right];
                    int threeSum = sum + nums[i];
                    if (Math.abs(target - threeSum) < closestSum) {
                        closestSum = Math.abs(target - threeSum);
                        res = threeSum;
                    }
                    if (sum > k) {
                        right--;
                    } else if (sum == k) {
                        return target;
                    } else {
                        left++;
                    }
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}