//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
// Related Topics 数组 哈希表 👍 546 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q454SiShuXiangJiaII {
    public static void main(String[] args) {
        Solution solution = new Q454SiShuXiangJiaII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            // nums1 - nums3 = num4 - nums2
            int n = nums1.length;
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int diff = nums1[i] + nums2[j];
                    map.put(diff, map.getOrDefault(diff, 0) + 1);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int diff = nums4[i] + nums3[j];
                    if (map.containsKey(-diff)) {
                        res += map.get(-diff);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}