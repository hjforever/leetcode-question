//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <=
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 589 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.TreeSet;

public class Q220CunZaiZhongFuYuanSuIII {
    public static void main(String[] args) {
        Solution solution = new Q220CunZaiZhongFuYuanSuIII().new Solution();
        solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            // sliding window and treeset
            int n = nums.length;
            TreeSet<Long> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                Long num = (long) nums[i];
                //小于等于 num 的最大值
                Long floor = treeSet.floor(num);
                //大于或等于num的最小值
                Long ceiling = treeSet.ceiling(num);
                if (floor != null && num - floor <= t) {
                    return true;
                }
                if (ceiling != null && ceiling - num <= t) {
                    return true;
                }
                treeSet.add(num);
                if (i >= k) {
                    treeSet.remove(nums[i - k] * 1L);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}