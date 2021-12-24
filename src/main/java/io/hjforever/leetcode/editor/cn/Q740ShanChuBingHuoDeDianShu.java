//给你一个整数数组 nums ，你可以对它进行一些操作。
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 哈希表 动态规划 👍 501 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q740ShanChuBingHuoDeDianShu {
    public static void main(String[] args) {
        Solution solution = new Q740ShanChuBingHuoDeDianShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            //数字统计频率
            //1 <= nums[i] <= 10^4
            int[] cnt = new int[10009];
            //算出最大max，则算出最大 f[max][1] || f[max][0]，因为都是正整数叠加，所以最大取max
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                cnt[nums[i]]++;
                max = Math.max(max, nums[i]);
            }
            //问题的关键是 将无序转为有序在得出转移方程
            //序列dp,虽然可以转换为一维dp（类似打家劫舍），但是不易于理解及分析
            //f[i][1]=f[i−1][0]+i∗cnts[i]
            // f[i][0] 代表「不选」数值 i；f[i][1] 代表「选择」数值 i
            int[][] dp = new int[max + 1][2];
            for (int i = 1; i <= max; i++) {
                dp[i][1] = dp[i - 1][0] + cnt[i] * i;
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            }
            //因为都是正整数叠加，所以最大取max
            return Math.max(dp[max][1], dp[max][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}