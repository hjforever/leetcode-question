//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 172 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer21DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMian {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer21DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMian().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            //双指针
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                //寻找偶数
                while (left < nums.length && nums[left] % 2 == 1) {
                    left++;
                }
                //寻找奇数
                while (right >= 0 && nums[right] % 2 == 0) {
                    right--;
                }

                //需要判断索引，防止越界
                if (left < right) {
                    //交换值
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }
            return nums;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}