//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 👍 1379 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q283YiDongLing {
    public static void main(String[] args) {
        Solution solution = new Q283YiDongLing().new Solution();
        solution.moveZeroes(new int[]{1, 2, 3, 0, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length < 2) return;
            int left = 0;
            int right = 0;
            int n = nums.length;
            while (right < n) {
                if (nums[right] != 0) {
                    //交换
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                }
                right++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}