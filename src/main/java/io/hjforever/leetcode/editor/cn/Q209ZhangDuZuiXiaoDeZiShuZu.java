//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1052 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q209ZhangDuZuiXiaoDeZiShuZu {
    public static void main(String[] args) {
        Solution solution = new Q209ZhangDuZuiXiaoDeZiShuZu().new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            return slidingWindow(target, nums);
        }


        //1.前缀和 prefix sum
        public int prefixSum(int target, int[] nums) {
            //前缀和
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for (int i = 0; i < nums.length; i++) {
                preSum[i+1] = preSum[i] + nums[i];
            }
            int res = Integer.MAX_VALUE;

            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    if (preSum[j] - preSum[i - 1] >= target) {
                        res = Math.min(res, (j - i + 1));
                    }
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }

        //2. sliding window
        public int slidingWindow(int target, int[] nums) {
            int left = 0;
            int right = 0;
            int n = nums.length;
            int sum = 0;
            int res = Integer.MAX_VALUE;
            while (right < n) {
                if (sum < target) {
                    sum += nums[right++];
                }
                while (sum >= target) {
                    res = Math.min(res, right - left);
                    sum -= nums[left++];
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}