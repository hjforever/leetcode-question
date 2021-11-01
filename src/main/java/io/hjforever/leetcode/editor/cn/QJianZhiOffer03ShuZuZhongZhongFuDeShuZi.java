//找出数组中重复的数字。
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 👍 591 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer03ShuZuZhongZhongFuDeShuZi {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer03ShuZuZhongZhongFuDeShuZi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            //排序 或者 hash都可以解决，但是时间复杂度或者空间复杂度高
            //可以通过 数组中的数字 在 0-n-1之间，通过比较索引来进行查询
            if (nums == null || nums.length == 0 || nums.length == 1) {
                return -1;
            }
            for (int i = 0; i < nums.length; i++) {
                //当索引不同时则交换
                while (nums[i] != i) {
                    //判断前面是否已经出现
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }
                    //交换值
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}