//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2846 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q42JieYuShui {
    public static void main(String[] args) {
        Solution solution = new Q42JieYuShui().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            // dp ,    min(leftMax,rightMax) - height[i] ;
            //关键求左侧最高及右侧最高
            // dp_left[i] = max(dp_left[i-1],height[i])
            // dp_right[i] = max(dp_right[i-1],height[i])

            if (height.length < 2) return 0;
            int res = 0;
            int n = height.length;
            int[] dpLeftMax = new int[n];
            int[] dpRightMax = new int[n];

            //left
            //两边的边界最大值为0,
            for (int i = 1; i < n - 1; i++) {
                //左侧列
                dpLeftMax[i] = Math.max(dpLeftMax[i - 1], height[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                //右侧列
                dpRightMax[i] = Math.max(dpRightMax[i + 1], height[i + 1]);
            }

            //求每一列的雨水，两侧边界列因不能接雨水则不需要考虑
            for (int i = 1; i < n - 1; i++) {
                int min = Math.min(dpLeftMax[i], dpRightMax[i]);
                if (min > height[i]) {
                    res += (min - height[i]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}