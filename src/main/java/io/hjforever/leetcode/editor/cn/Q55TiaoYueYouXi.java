//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1548 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q55TiaoYueYouXi {
    public static void main(String[] args) {
        Solution solution = new Q55TiaoYueYouXi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int newPoint = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                //当此数能达到最近的节点，则设置此节点为最近节点
                //当第一个节点为最近节点说明可以到达终点
                if (i + nums[i] >= newPoint) {
                    newPoint = i;
                }
            }
            return newPoint == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}