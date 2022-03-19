//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1379 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q560HeWeiKDeZiShuZu {
    public static void main(String[] args) {
        Solution solution = new Q560HeWeiKDeZiShuZu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            //前缀和
            if (nums.length == 1) return nums[0] != k ? 0 : 1;
            int res = 0;
            //两个数之和可以用hash表优化
            Map<Integer, Integer> map = new HashMap<>();
            //前缀和+hash
            int pre = 0;
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (pre == k) {
                    //当累加正好为k时
                    res++;
                }
                if (map.containsKey(pre - k)) {
                    res += map.get(pre - k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }


            //只用前缀和
            //int[] sum = new int[nums.length + 1];
            //            sum[0] = 0;
//            for (int i = 0; i < nums.length; i++) {
//                sum[i + 1] = sum[i] + nums[i];
//            }
//
//            for (int i = 0; i < sum.length; i++) {
//                for (int j = i + 1; j < sum.length; j++) {
            //前缀和
//                    if (sum[j] - sum[i] == k) {
//                        res++;
//                    }
//                }
//            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}