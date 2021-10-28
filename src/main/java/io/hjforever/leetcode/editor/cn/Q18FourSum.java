//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 987 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18FourSum {
    public static void main(String[] args) {
        Solution solution = new Q18FourSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums); // O(nlogn)
            int len = nums.length;
            for (int i = 0; i < len - 3; i++) {   // O(n^3)
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue; // 跳过重复
                }
                for (int j = i + 1; j < len - 2; j++) { // same as threeSum  O(n^2)
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue; // 跳过重复
                    }
                    int left = j + 1;
                    int right = len - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            // 跳过重复, 可以先不看
                            while (left < right && nums[left + 1] == nums[left]) left++;
                            while (left < right && nums[right - 1] == nums[right]) right--;
                            // 逼近中间
                            left++;
                            right--;
                        } else if (sum > target) {
                            right--;
                        } else { // sum < target
                            left++;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}