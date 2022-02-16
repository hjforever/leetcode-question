//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1451 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q34ZaiPaiXuShuZuZhongChaZhaoYuanSuDeDiYiGeHeZuiHouYiGeWeiZhi {
    public static void main(String[] args) {
        Solution solution = new Q34ZaiPaiXuShuZuZhongChaZhaoYuanSuDeDiYiGeHeZuiHouYiGeWeiZhi().new Solution();
        int[] nums = {1, 2, 2, 2, 3};
        solution.leftBound(nums, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int leftBound = leftBound(nums, target);
            int rigtBound = rightBound(nums, target);
            return new int[]{leftBound, rigtBound};
        }

        //binary search
        int binarySearch(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }

        //left bound
        int leftBound(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            if (left == nums.length) return -1;
            return nums[left] == target ? left : -1;
        }

        // right bound
        int rightBound(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;

                }
            }
            if (left == 0) return -1;
            return nums[left - 1] == target ? left - 1 : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}