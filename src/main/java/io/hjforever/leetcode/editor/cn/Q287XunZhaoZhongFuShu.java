//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 👍 1684 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q287XunZhaoZhongFuShu {
    public static void main(String[] args) {
        Solution solution = new Q287XunZhaoZhongFuShu().new Solution();
        System.out.println(solution.findDuplicate(new int[]{8, 7, 1, 10, 17, 15, 18, 11, 16, 9, 19, 12, 5, 14, 3, 4, 2, 13, 18, 18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            //without extra space
            // 基数排序
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (num != (i + 1)) {
                    if (nums[num - 1] == num) {
                        return num;
                    } else {
                        //交换
                        int temp = nums[num - 1];
                        nums[num - 1] = nums[i];
                        nums[i] = temp;
                    }
                }
            }
            return findDuplicate(nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}