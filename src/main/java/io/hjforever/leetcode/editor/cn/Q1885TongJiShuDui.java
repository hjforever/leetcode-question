//给你两个长度为 n 的整数数组 nums1 和 nums2 ，找出所有满足 i < j 且 nums1[i] + nums1[j] > nums2[i] +
// nums2[j] 的数对 (i, j) 。 
//
// 返回满足条件数对的 个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,1,2,1], nums2 = [1,2,1,2]
//输出：1
//解释：满足条件的数对有 1 个：(0, 2) ，因为 nums1[0] + nums1[2] = 2 + 2 > nums2[0] + nums2[2] =
// 1 + 1 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,10,6,2], nums2 = [1,4,1,5]
//输出：5
//解释：以下数对满足条件：
//- (0, 1) 因为 nums1[0] + nums1[1] = 1 + 10 > nums2[0] + nums2[1] = 1 + 4
//- (0, 2) 因为 nums1[0] + nums1[2] = 1 + 6 > nums2[0] + nums2[2] = 1 + 1
//- (1, 2) 因为 nums1[1] + nums1[2] = 10 + 6 > nums2[1] + nums2[2] = 4 + 1
//- (1, 3) 因为 nums1[1] + nums1[3] = 10 + 2 > nums2[1] + nums2[3] = 4 + 5
//- (2, 3) 因为 nums1[2] + nums1[3] = 6 + 2 > nums2[2] + nums2[3] = 1 + 5
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 1 <= n <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 排序 👍 5 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q1885TongJiShuDui {
    public static void main(String[] args) {
        Solution solution = new Q1885TongJiShuDui().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countPairs(int[] nums1, int[] nums2) {
            //通过差值将数组转换为一个数组
            //主要关键问题在于加法交换定律：
            //diff[i] + diff[j] = diff[j] + diff[i]
            // 所以谁在前根本无所谓，只要找到这样的两个数，i就是小的那个，j就是大的那个。
            // 这样就变成了找到 diff[i] + diff[j] > 0 当 i != j时。
            // 这就意味着我们可以对数组排序，因为对于每个j来说，只要我们找到满足的最小的i,
            // 比i大的那些位置的数都会满足（除了j）

            if (nums1 == null || nums1.length < 2) {
                return 0;
            }
            int n = nums1.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nums1[i] - nums2[i];
            }
            Arrays.sort(res);
            long count = 0;
            //双指针查找
            int left = 0;
            int right = res.length - 1;
            while (left < right) {
                if (res[left] + res[right] > 0) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}