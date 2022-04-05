//给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,-1,5,-2,3], k = 3
//输出: 4 
//解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,-1,2,1], k = 1
//输出: 2 
//解释: 子数组 [-1, 2] 和等于 1，且长度最长。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁹ <= k <= 10⁹ 
// 
// Related Topics 数组 哈希表 👍 157 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q325HeDengYuKDeZuiZhangZiShuZuZhangDu {
    public static void main(String[] args) {
        Solution solution = new Q325HeDengYuKDeZuiZhangZiShuZuZhangDu().new Solution();
        System.out.println(solution.maxSubArrayLen(new int[]{2, -1, 2, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            //1.prefix sum ,map
            //2.sliding window
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = nums[i] + sum[i];
            }
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                int s = sum[i];
                if (s == k) {
                    res = Math.max(res, i);
                }
                if (map.containsKey(s - k)) {
                    res = Math.max(res, i - map.get(s - k));
                }
                if (!map.containsKey(s)) {
                    map.put(s, i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}