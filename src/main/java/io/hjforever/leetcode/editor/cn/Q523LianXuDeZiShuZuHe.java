//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= sum(nums[i]) <= 2³¹ - 1 
// 1 <= k <= 2³¹ - 1 
// 
// Related Topics 数组 哈希表 数学 前缀和 👍 393 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q523LianXuDeZiShuZuHe {
    public static void main(String[] args) {
        Solution solution = new Q523LianXuDeZiShuZuHe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            //前缀和 + hash ,利用倍数取模值一致原理
            if (nums == null || nums.length < 2 || k == 0) return false;
            if (k == 1) return true;
            //前缀和
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 2; i <= n; i++) {
                set.add(sum[i - 2] % k);
                if (set.contains(sum[i] % k)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}